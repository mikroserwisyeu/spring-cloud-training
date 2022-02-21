package pl.training.payments;

import lombok.Value;
import org.javamoney.moneta.FastMoney;

import java.time.Instant;

@Value
public class Payment {

    String id;
    FastMoney value;
    Instant timestamp;
    PaymentsStatus status;

}
