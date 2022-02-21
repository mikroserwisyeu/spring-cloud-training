package pl.training.shop.payments.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.training.payments.GetPaymentUseCase;

@RequestMapping("payments")
@RestController
@RequiredArgsConstructor
public class GetPaymentUseCaseRestAdapter {

    private final GetPaymentUseCase getPaymentUseCase;
    private final PaymentsRestMapper paymentsRestMapper;

    @GetMapping("{id}")
    public ResponseEntity<PaymentDto> getById(@PathVariable String id) {
        var payment = getPaymentUseCase.getById(id);
        var paymentDto = paymentsRestMapper.toDto(payment);
        return ResponseEntity.ok(paymentDto);
    }

}
