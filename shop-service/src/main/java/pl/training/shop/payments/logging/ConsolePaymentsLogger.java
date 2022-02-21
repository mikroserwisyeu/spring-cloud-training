package pl.training.shop.payments.logging;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import pl.training.payments.Payment;
import pl.training.payments.PaymentRequest;

@Aspect
@Component
@Log
public class ConsolePaymentsLogger {

    @Pointcut("execution(* pl.training.shop.payments.TransactionalProcessPaymentUseCase.pro*(..))")
    void processPayment() {
    }

    @Before("processPayment() && args(paymentRequest)")
    public void beforeProcessPayment(PaymentRequest paymentRequest) {
        log.info("New payment request: " + paymentRequest);
    }

    @AfterReturning(value = "processPayment()", returning = "payment")
    public void onProcessPaymentSuccess(Payment payment) {
        log.info("New payment : " + payment);
    }

    @AfterThrowing(value = "processPayment()", throwing = "exception")
    public void onProcessPaymentSuccess(RuntimeException exception) {
        log.info("Processing payment failed: " + exception);
    }

}
