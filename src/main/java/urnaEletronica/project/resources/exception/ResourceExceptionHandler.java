package urnaEletronica.project.resources.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import urnaEletronica.project.services.exception.DatabaseException;
import urnaEletronica.project.services.exception.ObjectNotFoundException;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler  implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ObjectNotFoundException e, HttpServletRequest request){
        String error = "Resource not found"; // mensagem a ser exibida
        HttpStatus status = HttpStatus.NOT_FOUND; // status que deve ser mostrado, o numero do erro
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandardError> resourceNotFound(MethodArgumentTypeMismatchException e, HttpServletRequest request){
        String error = "Input is not the correct"; // mensagem a ser exibida
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // status que deve ser mostrado, o numero do erro
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST; // status que deve ser mostrado, o numero do erro
        StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}