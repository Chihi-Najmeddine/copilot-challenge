package sisal.it.copilot.challenge.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ExceptionResponse> handleException(EntityNotFoundException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(e.getMessage(),System.currentTimeMillis()));
    }

    @ExceptionHandler
    protected ResponseEntity<ExceptionResponse> handleException(MethodArgumentTypeMismatchException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(e.getMessage(),System.currentTimeMillis()));
    }

    @ExceptionHandler
    protected ResponseEntity<ExceptionResponse> handleException(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body(
                new ExceptionResponse(e.getMessage(),System.currentTimeMillis()));
    }
}
