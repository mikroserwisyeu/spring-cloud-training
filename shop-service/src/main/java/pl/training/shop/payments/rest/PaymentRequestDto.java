package pl.training.shop.payments.rest;

import lombok.Value;

import java.util.Map;

@Value
public class PaymentRequestDto {

    String value;
    Map<String, String> additionalInfo;

}
