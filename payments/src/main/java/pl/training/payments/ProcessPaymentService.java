package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class ProcessPaymentService {

    private final PaymentIdGenerator paymentIdGenerator;
    private final TimeProvider timeProvider;
    private final PaymentsWriterAdapter paymentsWriterAdapter;

    PaymentDomain process(PaymentRequestDomain paymentRequestDomain) {
        var paymentDomain = createPayment(paymentRequestDomain);
        paymentsWriterAdapter.save(paymentDomain);
        return paymentDomain;
    }

    private PaymentDomain createPayment(PaymentRequestDomain paymentRequestDomain) {
        return PaymentDomain.builder()
                .id(paymentIdGenerator.getNext())
                .value(paymentRequestDomain.getValue())
                .timestamp(timeProvider.getTimestamp())
                .status(PaymentsStatusDomain.STARTED)
                .build();
    }

}
