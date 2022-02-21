package pl.training.payments;

public interface PaymentsFactory {

    GetPaymentUseCase create(PaymentsReader paymentsReader);

    ProcessPaymentUseCase create(TimeProvider timeProvider, PaymentsWriter paymentsWriter);

}
