package com.wintercamp.piademo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wintercamp.piademo.error.DefaultExceptionMessage;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ResponseBody
    @ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultExceptionMessage> constraintViolationException(MethodArgumentNotValidException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.PRECONDITION_FAILED.value());
        dex.setMessage(e.getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(dex);
    }
	
	

	
	@ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<DefaultExceptionMessage> objectNotFoundException(RuntimeException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        dex.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dex);
    }
	
	
	@ResponseBody
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<DefaultExceptionMessage> nullPointerException(NullPointerException e) {
        DefaultExceptionMessage dex = new DefaultExceptionMessage();
        dex.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        dex.setMessage("Yazılımcıyı döv");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(dex);
    }
	
	
}
