package pl.training.shop.payments.rest;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.training.payments.PaymentNotFoundException;
import pl.training.shop.commons.web.ExceptionDto;
import pl.training.shop.commons.web.GlobalExceptionHandler;

import java.util.Locale;

@RestControllerAdvice(basePackages = "pl.training.shop.payments.rest")
public class PaymentsExceptionHandler extends GlobalExceptionHandler {

    public PaymentsExceptionHandler(MessageSource messageSource) {
        super(messageSource);
    }

    @ExceptionHandler(PaymentNotFoundException.class)
    public ResponseEntity<ExceptionDto> onPaymentNotFoundException(PaymentNotFoundException exception, Locale locale) {
        return createResponse(exception, HttpStatus.NOT_FOUND, locale);
    }

}
