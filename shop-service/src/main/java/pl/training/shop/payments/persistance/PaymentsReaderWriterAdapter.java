package pl.training.shop.payments.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.training.payments.Payment;
import pl.training.payments.PaymentsReader;
import pl.training.payments.PaymentsWriter;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PaymentsReaderWriterAdapter implements PaymentsReader, PaymentsWriter {

    private final JpaPaymentsRepository paymentsRepository;
    private final PaymentPersistenceMapper persistenceMapper;

    @Override
    public Optional<Payment> getById(String id) {
        return paymentsRepository.findById(id)
                .map(persistenceMapper::toModel);
    }

    @Override
    public Payment save(Payment payment) {
        var entity = persistenceMapper.toEntity(payment);
        return persistenceMapper.toModel(paymentsRepository.save(entity));
    }

}
