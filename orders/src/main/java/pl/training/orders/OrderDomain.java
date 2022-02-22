package pl.training.orders;

import lombok.Value;
import org.javamoney.moneta.FastMoney;
import pl.training.commons.LocalFastMoney;

import java.util.List;

@Value
class OrderDomain {

    Long id;
    List<OrderEntryDomain> entries;

    FastMoney getTotalValue() {
        return entries.stream()
                .map(entry -> entry.getPrice().multiply(entry.getQuantity()))
                .reduce(LocalFastMoney.zero(), FastMoney::add);
    }

}
