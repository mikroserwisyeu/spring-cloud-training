package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ProcessPaymentUseCaseAdapter implements ProcessPaymentUseCase {

    private final ProcessPaymentService processPaymentService;
    private final PaymentsMapper paymentsMapper;

    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var paymentRequestDomain = paymentsMapper.toDomain(paymentRequest);
        var paymentDomain = processPaymentService.process(paymentRequestDomain);
        return paymentsMapper.toModel(paymentDomain);
    }

}
