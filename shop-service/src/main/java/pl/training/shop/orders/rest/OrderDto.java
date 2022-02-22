package pl.training.shop.orders.rest;

import lombok.Value;

import java.util.Map;

@Value
public class OrderDto {

    Long id;
    Map<Long, Integer> entries;

}
