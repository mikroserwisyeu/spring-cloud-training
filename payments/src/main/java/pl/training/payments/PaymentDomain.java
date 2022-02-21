package pl.training.payments;

import lombok.Builder;
import lombok.Value;
import org.javamoney.moneta.FastMoney;

import java.time.Instant;

@Builder
@Value
class PaymentDomain {

    String id;
    FastMoney value;
    Instant timestamp;
    PaymentsStatusDomain status;

}
