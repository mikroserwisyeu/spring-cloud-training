package pl.training.shop.payments.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import pl.training.commons.FastMoneyMapper;
import pl.training.payments.Payment;
import pl.training.payments.PaymentRequest;
import pl.training.payments.PaymentsStatus;

@Mapper(componentModel = "spring", uses = FastMoneyMapper.class)
public interface PaymentsRestMapper {

    @Mapping(source = "additionalInfo", target = "properties")
    PaymentRequest toModel(PaymentRequestDto paymentRequestDto);

    PaymentDto toDto(Payment payment);

    @ValueMapping(source = "STARTED", target = "NOT_CONFIRMED")
    @ValueMapping(source = "FAILED", target = "NOT_CONFIRMED")
    @ValueMapping(source = "CANCELED", target = "NOT_CONFIRMED")
    PaymentsStatusDto toDto(PaymentsStatus paymentsStatus);

}
