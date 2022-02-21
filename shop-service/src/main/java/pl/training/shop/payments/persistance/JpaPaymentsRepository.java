package pl.training.shop.payments.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPaymentsRepository extends JpaRepository<PaymentEntity, String> {
}
