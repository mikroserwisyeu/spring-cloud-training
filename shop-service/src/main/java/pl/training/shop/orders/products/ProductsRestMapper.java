package pl.training.shop.orders.products;

import org.mapstruct.Mapper;
import pl.training.commons.FastMoneyMapper;
import pl.training.orders.Product;

@Mapper(componentModel = "spring", uses = FastMoneyMapper.class)
public interface ProductsRestMapper {

    Product toModel(ProductDto productDto);

}
