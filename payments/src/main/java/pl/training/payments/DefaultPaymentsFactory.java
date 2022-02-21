package pl.training.payments;

import org.mapstruct.factory.Mappers;

public class DefaultPaymentsFactory implements PaymentsFactory {

    private static final PaymentsMapper PAYMENTS_MAPPER = Mappers.getMapper(PaymentsMapper.class);
    private static final PaymentIdGenerator PAYMENT_ID_GENERATOR = new UUIDPaymentIdGenerator();

    @Override
    public GetPaymentUseCase create(PaymentsReader paymentsReader) {
        var readerAdapter = new PaymentsReaderAdapter(paymentsReader, PAYMENTS_MAPPER);
        var getPaymentService = new GetPaymentService(readerAdapter);
        return new GetPaymentUseCaseAdapter(getPaymentService, PAYMENTS_MAPPER);
    }

    @Override
    public ProcessPaymentUseCase create(TimeProvider timeProvider, PaymentsWriter paymentsWriter) {
        var writerAdapter = new PaymentsWriterAdapter(paymentsWriter, PAYMENTS_MAPPER);
        var processPaymentService = new ProcessPaymentService(PAYMENT_ID_GENERATOR, timeProvider, writerAdapter);
        return new ProcessPaymentUseCaseAdapter(processPaymentService, PAYMENTS_MAPPER);
    }

}
