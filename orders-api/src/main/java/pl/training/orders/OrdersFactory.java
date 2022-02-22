package pl.training.orders;

public interface OrdersFactory {

    PlaceOrderUseCase create(PaymentsService paymentsService, ProductsProvider productsProvider);

}
