package pl.training.shop.payments.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.training.payments.ProcessPaymentUseCase;
import pl.training.shop.commons.web.UriBuilder;

@RequestMapping("payments")
@RestController
@RequiredArgsConstructor
public class ProcessPaymentUseCaseRestAdapter {

    private final ProcessPaymentUseCase processPaymentUseCase;
    private final PaymentsRestMapper paymentsRestMapper;

    @PostMapping
    public ResponseEntity<PaymentDto> process(@RequestBody PaymentRequestDto paymentRequestDto) {
        var paymentRequest = paymentsRestMapper.toModel(paymentRequestDto);
        var payment = processPaymentUseCase.process(paymentRequest);
        var paymentDto = paymentsRestMapper.toDto(payment);
        var locationUri = UriBuilder.requestUriWithId(paymentDto.getId());
        return ResponseEntity.created(locationUri).body(paymentDto);
    }

}
