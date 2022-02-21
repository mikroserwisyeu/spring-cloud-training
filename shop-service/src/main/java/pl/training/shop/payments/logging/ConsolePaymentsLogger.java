package pl.training.shop.payments.logging;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.training.payments.PaymentRequest;

@Aspect
@Component
@Log
public class ConsolePaymentsLogger {

    @Before("execution(* pl.training.shop.payments.TransactionalProcessPaymentUseCase.pro*(..)) && args(paymentRequest)")
    public void beforeProcessPayment(PaymentRequest paymentRequest) {
        log.info("New payment request: " + paymentRequest);
    }

}
