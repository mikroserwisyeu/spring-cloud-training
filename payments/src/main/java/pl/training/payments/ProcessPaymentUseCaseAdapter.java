package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import pl.training.commons.Atomic;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ProcessPaymentUseCaseAdapter implements ProcessPaymentUseCase {

    private final ProcessPaymentService processPaymentService;
    private final PaymentsMapper paymentsMapper;

    //@Atomic
    @Override
    public Payment process(PaymentRequest paymentRequest) {
        var paymentRequestDomain = paymentsMapper.toDomain(paymentRequest);
        var paymentDomain = processPaymentService.process(paymentRequestDomain);
        return paymentsMapper.toModel(paymentDomain);
    }

}
