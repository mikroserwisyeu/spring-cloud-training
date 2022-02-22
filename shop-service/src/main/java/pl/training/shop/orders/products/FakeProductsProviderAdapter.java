package pl.training.shop.orders.products;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;
import pl.training.commons.LocalFastMoney;
import pl.training.commons.Page;
import pl.training.commons.ResultPage;
import pl.training.orders.Product;
import pl.training.orders.ProductsProvider;

@Component
public class FakeProductsProviderAdapter implements ProductsProvider {

    @Override
    public ResultPage<Product> getProducts(Page page) {
        throw new NotYetImplementedException();
    }

    @Override
    public Product getProduct(Long id) {
        return new Product(1L, "Fake product", LocalFastMoney.of(100));
    }

}
