package pl.training.shop.payments.rest;

import lombok.Value;
import pl.training.shop.commons.Base;
import pl.training.shop.commons.Extended;
import pl.training.shop.commons.money.Money;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Map;

@Value
public class PaymentRequestDto {

    @Money(groups = Base.class)
    @Pattern(regexp = "\\d+ [A-Z]", groups = Extended.class)
    String value;
    @NotEmpty(groups = Extended.class)
    Map<String, String> additionalInfo;

}
