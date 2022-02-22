package pl.training.orders;

import lombok.Value;
import org.javamoney.moneta.FastMoney;

@Value
class OrderEntryDomain {

    Long productId;
    FastMoney price;
    int quantity;

}
