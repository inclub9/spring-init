package co.autopair.spring.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class CommonException extends RuntimeException {

    protected HttpStatus status;
    protected String code;

    public CommonException(String message) {
        super(message);
    }


}
