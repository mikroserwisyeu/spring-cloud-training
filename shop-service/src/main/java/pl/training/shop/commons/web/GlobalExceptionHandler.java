package pl.training.shop.commons.web;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private static final String KEY_VALUE_SEPARATOR = ": ";
    private static final String DELIMITER = ", ";

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionDto> onMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        var description = getValidationErrors(exception);
        return ResponseEntity.badRequest().body(new ExceptionDto(description));
    }

    private String getValidationErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + KEY_VALUE_SEPARATOR + error.getDefaultMessage())
                .collect(Collectors.joining(DELIMITER));
    }

    protected ResponseEntity<ExceptionDto> createResponse(Exception exception, HttpStatus httpStatus, Locale locale) {
        var key = exception.getClass().getName();
        String description;
        try {
            description = messageSource.getMessage(key, new Object[] {}, locale);
        } catch (NoSuchMessageException ex) {
            description = exception.getClass().getSimpleName();
        }
        return ResponseEntity.status(httpStatus).body(new ExceptionDto(description));
    }

}
