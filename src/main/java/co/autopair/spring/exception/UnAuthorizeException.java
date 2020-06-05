package co.autopair.spring.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class UnAuthorizeException extends CommonException {

    private final HttpStatus status = HttpStatus.UNAUTHORIZED;
    private final String code = "401";

    public UnAuthorizeException(String message) {
        super(message);
    }
}
