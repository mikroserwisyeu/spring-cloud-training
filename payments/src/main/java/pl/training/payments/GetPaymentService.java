package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetPaymentService {

    private final PaymentsReaderAdapter paymentsReaderAdapter;

    PaymentDomain getById(String id) {
        return paymentsReaderAdapter.getById(id)
                .orElseThrow(PaymentNotFoundException::new);
    }

}
