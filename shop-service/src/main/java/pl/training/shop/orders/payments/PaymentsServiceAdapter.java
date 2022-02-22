package pl.training.shop.orders.payments;

import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;
import org.springframework.stereotype.Component;
import pl.training.orders.Payment;
import pl.training.orders.PaymentsService;
import pl.training.payments.PaymentRequest;
import pl.training.payments.ProcessPaymentUseCase;

import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentsServiceAdapter implements PaymentsService {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @Override
    public Optional<Payment> pay(Long requestId, FastMoney value, Map<String, String> properties) {
        var paymentRequest = new PaymentRequest(value, properties);
        var payment = processPaymentUseCase.process(paymentRequest);
        return Optional.of(new Payment(payment.getId(), payment.getStatus().name()));
    }

}
