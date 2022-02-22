package pl.training.orders;

import org.mapstruct.factory.Mappers;

public class DefaultOrdersFactory implements OrdersFactory {

    private static final OrdersMapper ORDERS_MAPPER = Mappers.getMapper(OrdersMapper.class);

    @Override
    public PlaceOrderUseCase create(PaymentsService paymentsService, ProductsProvider productsProvider) {
        var placeOrderService = new PlaceOrderService(paymentsService);
        ORDERS_MAPPER.setProductsProvider(productsProvider);
        return new PlaceOrderUseCaseAdapter(placeOrderService, ORDERS_MAPPER);
    }

}
