package pl.training.shop.payments.persistance;

import org.mapstruct.Mapper;
import pl.training.payments.Payment;

@Mapper(componentModel = "spring")
public interface PaymentPersistenceMapper {

    PaymentEntity toEntity(Payment payment);

    Payment toModel(PaymentEntity paymentEntity);

}
