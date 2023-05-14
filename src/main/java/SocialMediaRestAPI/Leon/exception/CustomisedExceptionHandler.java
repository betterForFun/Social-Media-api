package SocialMediaRestAPI.Leon.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import SocialMediaRestAPI.Leon.Users.UserNotFoundException;

@ControllerAdvice
public class CustomisedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<errorDetails> handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		errorDetails errorDetails = new errorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<errorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
 
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<errorDetails> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		errorDetails errorDetails = new errorDetails(LocalDateTime.now(), 
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<errorDetails>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(
//			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
//				"Total Errors:" + ex.getErrorCount() + " First Error:" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));
//		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
//	}

}
