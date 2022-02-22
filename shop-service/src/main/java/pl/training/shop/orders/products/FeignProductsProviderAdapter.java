package pl.training.shop.orders.products;

import feign.FeignException.FeignClientException;
import lombok.RequiredArgsConstructor;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import pl.training.commons.Page;
import pl.training.commons.ResultPage;
import pl.training.orders.Product;
import pl.training.orders.ProductsProvider;

@Primary
@Component
@RequiredArgsConstructor
public class FeignProductsProviderAdapter  implements ProductsProvider {

    private final ProductsApi productsApi;
    private final ProductsRestMapper productsRestMapper;

    @Override
    public ResultPage<Product> getProducts(Page page) {
        throw new NotYetImplementedException();
    }

    @Override
    public Product getProduct(Long id) {
        try {
            var productDto = productsApi.getProduct(id);
            return productsRestMapper.toModel(productDto);
        } catch (FeignClientException exception) {
            throw new ServiceUnavailableException();
        }
    }

}
