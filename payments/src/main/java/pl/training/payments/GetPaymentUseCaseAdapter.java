package pl.training.payments;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PACKAGE)
class GetPaymentUseCaseAdapter implements GetPaymentUseCase {

    private final GetPaymentService getPaymentService;
    private final PaymentsMapper paymentsMapper;

    @Override
    public Payment getById(String id) {
        return paymentsMapper.toModel(getPaymentService.getById(id));
    }

}
