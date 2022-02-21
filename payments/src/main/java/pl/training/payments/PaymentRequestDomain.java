package pl.training.payments;

import lombok.Value;
import org.javamoney.moneta.FastMoney;

import java.util.Map;

@Value
class PaymentRequestDomain {

    FastMoney value;
    Map<String, String> properties;

}
