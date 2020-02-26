package pl.agawesolowska.learningspringboot.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

		StudentErrorResponse error = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
				System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
