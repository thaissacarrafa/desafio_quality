package com.meli.desafio_quality.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HandlerException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(
        NotFoundException e
    ) {
        ExceptionDetails exceptionDetails = ExceptionDetails
            .builder()
            .title("Not Found")
            .message(e.getMessage())
            .status(HttpStatus.NOT_FOUND.value())
            .timeStamp(LocalDateTime.now())
            .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}
