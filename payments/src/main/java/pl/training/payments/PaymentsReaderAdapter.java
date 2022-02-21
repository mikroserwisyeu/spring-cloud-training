package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class PaymentsReaderAdapter {

    private final PaymentsReader paymentsReader;
    private final PaymentsMapper paymentsMapper;

    Optional<PaymentDomain> getById(String id) {
        return paymentsReader.getById(id)
                .map(paymentsMapper::toDomain);
    }

}
