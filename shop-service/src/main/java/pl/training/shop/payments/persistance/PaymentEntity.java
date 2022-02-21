package pl.training.shop.payments.persistance;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.javamoney.moneta.FastMoney;
import pl.training.payments.PaymentsStatus;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Table(name = "PAYMENTS")
@Entity
@EqualsAndHashCode(of = "id")
@Data
public class PaymentEntity {

    @Id
    private String id;
    private FastMoney value;
    private Instant timestamp;
    private String status;

}
