package pl.training.shop.orders.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.orders.PlaceOrderUseCase;

@RequestMapping("orders")
@RestController
@RequiredArgsConstructor
public class PlaceOrderUseCaseRestAdapter {

    private final PlaceOrderUseCase placeOrderUseCase;
    private final OrdersRestMapper ordersRestMapper;

    @PostMapping
    public ResponseEntity<Void> place(@RequestBody OrderDto orderDto) {
        var order = ordersRestMapper.toModel(orderDto);
        placeOrderUseCase.place(order);
        return ResponseEntity.accepted().build();
    }

}
