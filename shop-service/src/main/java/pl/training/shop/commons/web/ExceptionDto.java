package pl.training.shop.commons.web;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ExceptionDto {

    String description;
    LocalDateTime timestamp = LocalDateTime.now();

}
