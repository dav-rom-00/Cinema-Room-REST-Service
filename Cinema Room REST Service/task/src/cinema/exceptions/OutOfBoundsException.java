package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OutOfBoundsException extends RuntimeException {
    public OutOfBoundsException(String errorMsg) {
        super(errorMsg);
    }
}
