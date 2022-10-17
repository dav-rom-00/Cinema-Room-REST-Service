package cinema.exceptions;

import java.util.Date;

public class ExceptionResponse {
    private Date timestamp;
    private int status;
    private String error;

    public ExceptionResponse(Date timestamp, int status, String error) {
        super();
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }
}

