package pl.training.orders;

import pl.training.commons.Page;
import pl.training.commons.ResultPage;

public interface ProductsProvider {

    ResultPage<Product> getProducts(Page page);

    Product getProduct(Long id);

}
