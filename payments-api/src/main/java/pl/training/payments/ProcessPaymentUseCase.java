package pl.training.payments;

public interface ProcessPaymentUseCase {

    Payment process(PaymentRequest paymentRequest);

}
