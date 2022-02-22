package pl.training.shop.orders.products;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import pl.training.commons.Page;
import pl.training.commons.ResultPage;
import pl.training.orders.Product;
import pl.training.orders.ProductsProvider;

@Primary
@Component
@RequiredArgsConstructor
public class RestTemplateProductsProviderAdapter implements ProductsProvider {

    private final RestTemplate restTemplate;
    private final ProductsRestMapper productsRestMapper;
    @Value("${api.products}")
    @Setter
    private String productsEndpoint;

    @Override
    public ResultPage<Product> getProducts(Page page) {
        throw new NotYetImplementedException();
    }

    @Override
    public Product getProduct(Long id) {
        try {
            var productDto = restTemplate.getForObject(productsEndpoint + id, ProductDto.class);
            return productsRestMapper.toModel(productDto);
        } catch (RestClientException exception) {
            throw new ServiceUnavailableException();
        }
    }

}
