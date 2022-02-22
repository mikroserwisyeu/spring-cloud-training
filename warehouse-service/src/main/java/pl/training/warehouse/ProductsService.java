package pl.training.warehouse;

import pl.training.commons.Page;
import pl.training.commons.ResultPage;

interface ProductsService {

    ResultPage<Product> getProducts(Page page);

    Product getProduct(Long id);

}
