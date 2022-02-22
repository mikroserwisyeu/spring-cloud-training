package pl.training.shop.orders.products;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("WAREHOUSE-SERVICE")
public interface ProductsApi {

    @GetMapping("products/{id}")
    ProductDto getProduct(@PathVariable Long id);

}
