package pl.training.orders;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PlaceOrderUseCaseAdapter implements PlaceOrderUseCase {

    private final PlaceOrderService placeOrderService;
    private final OrdersMapper ordersMapper;

    @Override
    public void place(Order order) {
        var orderDomain = ordersMapper.toDomain(order);
        placeOrderService.place(orderDomain);
    }

}
