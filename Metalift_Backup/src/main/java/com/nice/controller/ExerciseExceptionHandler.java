package com.nice.controller;



import com.nice.exception.EmptyListException;
import com.nice.exception.ExerciseNotFoundException;
import com.nice.exception.MissingMandatoryElementException;
import lombok.extern.java.Log;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.nice.exception.ErrorResponse;

import java.util.NoSuchElementException;


@ControllerAdvice
public class ExerciseExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> duplicateExerciseException( DataIntegrityViolationException exception, WebRequest request
    ){

        Exception e = new Exception("Exercise with the same parameters already exists.");

        return buildErrorResponse(e, HttpStatus.UNPROCESSABLE_ENTITY, request);


    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> exerciseNotFoundException( EmptyResultDataAccessException exception, WebRequest request
    ){

        Exception e = new Exception("Exercise doesn't exist.");

        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);


    }

    @ExceptionHandler(EmptyListException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> emptyExerciseListException(EmptyListException exception, WebRequest request
    ){

        Exception e = new Exception("List of exercises is empty.");

        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);


    }

    @ExceptionHandler(ExerciseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> exerciseNotFoundException(ExerciseNotFoundException exception, WebRequest request
    ){

        Exception e = new Exception("Exercise with given id doesn't exist.");

        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);


    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> exerciseNotFoundException(NoSuchElementException exception, WebRequest request
    ){

        Exception e = new Exception("Exercise with given id doesn't exist.");

        return buildErrorResponse(e, HttpStatus.NOT_FOUND, request);


    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorResponse> badrequestException(NullPointerException exception, WebRequest request
    ){

        Exception e = new Exception("Bad Request.");

        return buildErrorResponse(e, HttpStatus.BAD_REQUEST, request);


    }

    @ExceptionHandler(MissingMandatoryElementException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> mandatoryException(MissingMandatoryElementException exception, WebRequest request
    ){

        Exception e = new Exception("Bad Request.");

        return buildErrorResponse(e, HttpStatus.BAD_REQUEST, request);


    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            HttpStatus errorCode,
            WebRequest request
    ) {
        return buildErrorResponse(
                exception,
                exception.getMessage(),
                errorCode,
                request);
    }

   private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            String errorMessage,
            HttpStatus errorCode,
            WebRequest request
    )   {
        ErrorResponse errorResponse = new ErrorResponse(
                errorCode.value(),
                exception.getMessage()
        );

        return ResponseEntity.status(errorCode).body(errorResponse);

    }

}