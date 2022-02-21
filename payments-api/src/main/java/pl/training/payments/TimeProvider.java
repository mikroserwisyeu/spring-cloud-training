package pl.training.payments;

import java.time.Instant;

public interface TimeProvider {

    Instant getTimestamp();

}
