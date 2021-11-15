package com.nice.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final int errorCode;
    private final String errorMessage;

}