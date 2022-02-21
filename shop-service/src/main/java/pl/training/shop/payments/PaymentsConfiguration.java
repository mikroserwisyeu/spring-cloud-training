package pl.training.shop.payments;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.training.payments.*;

@Configuration
public class PaymentsConfiguration {

    private static final PaymentsFactory PAYMENTS_FACTORY = new DefaultPaymentsFactory();

    @Bean
    public GetPaymentUseCase getPaymentUseCase(PaymentsReader paymentsReader) {
        return PAYMENTS_FACTORY.create(paymentsReader);
    }

    @Bean
    public ProcessPaymentUseCase processPaymentUseCase(TimeProvider timeProvider, PaymentsWriter paymentsWriter) {
        return PAYMENTS_FACTORY.create(timeProvider, paymentsWriter);
    }

}
