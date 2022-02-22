package pl.training.orders;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import static java.util.Collections.emptyMap;

@Log
@RequiredArgsConstructor
class PlaceOrderService {

    private final PaymentsService paymentsService;

    void place(OrderDomain orderDomain) {
        var paymentValue = orderDomain.getTotalValue();
        // load payment properties and generate request id
        var payment = paymentsService.pay(1L, paymentValue, emptyMap());
        log.info("New order: " + orderDomain);
        log.info("New order payment: " + payment);
    }

}
