package pl.training.orders;

import lombok.Setter;
import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

@Mapper
abstract class OrdersMapper {

    @Setter
    private ProductsProvider productsProvider;

    OrderDomain toDomain(Order order) {
        return new OrderDomain(order.getId(), toDomain(order.getEntries()));
    }

    private List<OrderEntryDomain> toDomain(Map<Long, Integer> entries) {
        return entries.entrySet().stream()
                .map(entry -> new OrderEntryDomain(entry.getKey(), getPrice(entry.getKey()), entry.getValue()))
                .collect(toList());
    }

    private FastMoney getPrice(Long productId) {
        return productsProvider.getProduct(productId).getPrice();
    }

}
