package pl.training.commons;

import org.javamoney.moneta.FastMoney;
import org.mapstruct.Mapper;

@Mapper
public class FastMoneyMapper {

    public FastMoney toMoney(String text) {
        return text != null ? FastMoney.parse(text) : LocalFastMoney.zero();
    }

    public String toText(FastMoney money) {
        return money != null ? money.toString() : LocalFastMoney.zero().toString();
    }

    public FastMoney toMoney(Long value) {
        return  value != null ? LocalFastMoney.of(value) : LocalFastMoney.zero();
    }

}
