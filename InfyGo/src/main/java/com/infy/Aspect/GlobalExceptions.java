package com.infy.Aspect;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infy.Exception.*;

import ch.qos.logback.core.status.Status;
import net.bytebuddy.description.modifier.MethodArguments;

@RestControllerAdvice
public class GlobalExceptions {

	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInfo> handleValidationException(MethodArgumentNotValidException ex){
		ErrorInfo error = new ErrorInfo();
		error.setErrorCode(HttpStatus.BAD_GATEWAY.value());
		List<ObjectError> objectErrors = ex.getAllErrors();
		String msg = objectErrors.stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.joining(","));
		error.setErrorMsg(msg);
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInfo> handleConstrainViolationException(ConstraintViolationException ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(",")));
		return new ResponseEntity<ErrorInfo>(errorInfo, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(UserAllReadyExist.class)
	public ResponseEntity<ErrorInfo> handerUserAllreadyExist(UserAllReadyExist ex){
		ErrorInfo errorInfo = new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.CONFLICT.value());
		errorInfo.setErrorMsg(ex.getMessage());
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UserNotExist.class)
	public ResponseEntity<ErrorInfo> handlUserNotExist(UserNotExist ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(FlightNotExist.class)
	public ResponseEntity<ErrorInfo> handlFlightNotExist(FlightNotExist ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SeatNotAvailable.class)
	public ResponseEntity<ErrorInfo> handlseatNotAvailable(SeatNotAvailable ex){
		ErrorInfo errorInfo=new ErrorInfo();
		errorInfo.setErrorCode(HttpStatus.BAD_REQUEST.value());
		errorInfo.setErrorMsg(ex.getMessage());
		
		return new ResponseEntity<ErrorInfo>(errorInfo,HttpStatus.BAD_REQUEST);
	}
	
}