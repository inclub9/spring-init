package co.autopair.spring.controller.advice;

import co.autopair.spring.exception.CommonException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;


//@ControllerAdvice
//@ResponseBody
@RestControllerAdvice
public class CommonAdvice extends ResponseEntityExceptionHandler {


    //
//
//// 2
    private ResponseEntity<Object> handle(String message, HttpStatus status, String code) {
        ExceptionResponse response = new ExceptionResponse();
        response.setCode("xxx-" + code);
        response.setMessage(message);
        response.setTimestamp(LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add("x-info", "https://domain-name/context-path/api/v1/errors/" + code);
        return ResponseEntity.status(status).headers(headers).body(response);
    }

    ////3
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handle(ex.getMessage(), status, String.valueOf(status.value()));
    }
//
//

    //
//
////4
    @ExceptionHandler(CommonException.class)
    protected ResponseEntity<Object> handleCommonException(CommonException ex) {
        return handle(ex.getMessage(), ex.getStatus(), ex.getCode());
    }

    //
//
////5
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        return handle(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    //// 1
    @Getter
    @Setter
    private class ExceptionResponse {
        private String code;
        private String message;
        private LocalDateTime timestamp;
    }
}
