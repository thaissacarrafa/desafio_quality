package com.meli.desafio_quality.exception;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDetails {

    private String message;
    private String title;
    private int status;
    private LocalDateTime timeStamp;
}
