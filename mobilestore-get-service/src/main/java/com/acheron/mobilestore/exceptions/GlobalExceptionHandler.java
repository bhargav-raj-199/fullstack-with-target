package com.acheron.mobilestore.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.acheron.mobilestore.model.ApiErrors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String error="Request Method not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error="Media Type not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error="Missing PathVariable not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error="Missing Request Parameter not supported";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String error="Type mismatch";
		String message=ex.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),ex.getMessage(), status,status.value(), error);
		headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(status).headers(headers).body(errors);
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFound(IdNotFoundException e){
		String error="Id not found";
		String message=e.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message, HttpStatus.NO_CONTENT,HttpStatus.NO_CONTENT.value(), error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(errors);
	}
	
	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<Object> handleIdNotFound(NoDataException e){
		String error="Database is Empty";
		String message=e.getMessage();
		ApiErrors errors=new ApiErrors(LocalDateTime.now(),message, HttpStatus.NO_CONTENT,HttpStatus.NO_CONTENT.value(), error);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", message);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(errors);
	}
	
}
