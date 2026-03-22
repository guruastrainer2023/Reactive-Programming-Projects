package com.training.ui;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.training.exception.CustomerAlreadyExistsException;
import com.training.exception.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value
             = {CustomerAlreadyExistsException.class})
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorResponse handleException(CustomerAlreadyExistsException ex)
    {
        return new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}
