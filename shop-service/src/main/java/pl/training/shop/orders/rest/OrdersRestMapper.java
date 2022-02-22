package pl.training.shop.orders.rest;

import org.mapstruct.Mapper;
import pl.training.orders.Order;

@Mapper(componentModel = "spring")
public interface OrdersRestMapper {

    Order toModel(OrderDto orderDto);

}
