package pl.training.payments;

import java.util.Optional;

public interface PaymentsReader {

    Optional<Payment> getById(String id);

}
