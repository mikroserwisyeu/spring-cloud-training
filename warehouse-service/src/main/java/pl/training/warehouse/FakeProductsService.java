package pl.training.warehouse;

import org.springframework.stereotype.Service;
import pl.training.commons.Page;
import pl.training.commons.ResultPage;

import java.util.List;

@Service
class FakeProductsService implements ProductsService {

    private static final List<Product> PRODUCTS = List.of(
            new Product(1L, "Spring in action", 200L),
            new Product(2L, "Angular in action", 100L)
    );

    @Override
    public ResultPage<Product> getProducts(Page page) {
        return new ResultPage<>(PRODUCTS, new Page(0, 5), 2);
    }

    @Override
    public Product getProduct(Long id) {
        return PRODUCTS.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
