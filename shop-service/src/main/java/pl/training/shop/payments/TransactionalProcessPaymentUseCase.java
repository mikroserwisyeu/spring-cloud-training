package pl.training.shop.payments;

import lombok.RequiredArgsConstructor;
import pl.training.payments.Payment;
import pl.training.payments.PaymentRequest;
import pl.training.payments.ProcessPaymentUseCase;
import pl.training.shop.commons.TransactionalProxy;

@TransactionalProxy
@RequiredArgsConstructor
public class TransactionalProcessPaymentUseCase implements ProcessPaymentUseCase {

    private final ProcessPaymentUseCase processPaymentUseCase;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        return processPaymentUseCase.process(paymentRequest);
    }

}
