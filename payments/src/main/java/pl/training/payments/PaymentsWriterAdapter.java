package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PaymentsWriterAdapter {

    private final PaymentsWriter paymentsWriter;
    private final PaymentsMapper paymentsMapper;

    PaymentDomain save(PaymentDomain paymentDomain) {
        var payment = paymentsMapper.toModel(paymentDomain);
        return paymentsMapper.toDomain(paymentsWriter.save(payment));
    }

}
