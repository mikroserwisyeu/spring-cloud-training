package pl.training.payments;

import org.mapstruct.Mapper;

@Mapper
interface PaymentsMapper {

    PaymentDomain toDomain(Payment payment);

    Payment toModel(PaymentDomain paymentDomain);

    PaymentRequestDomain toDomain(PaymentRequest paymentRequest);

}
