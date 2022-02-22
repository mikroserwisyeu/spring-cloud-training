package pl.training.warehouse;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("products")
@RestController
@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ProductsController {

    private final ProductsService productsService;
    private final ProductsRestMapper productsRestMapper;

    @GetMapping("{id}")
    ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        var product = productsService.getProduct(id);
        return ResponseEntity.ok(productsRestMapper.toDto(product));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<Void> onProductNotFound() {
        return ResponseEntity.notFound().build();
    }

}
