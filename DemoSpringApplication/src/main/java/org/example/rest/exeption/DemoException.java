package org.example.rest.exeption;

import org.springframework.http.HttpStatus;

public class DemoException extends RuntimeException {

    private final HttpStatus status;

    public DemoException( DemoExceptionCode code, Object... arg ) {
        super( String.format( code.getMessage(), arg ) );
        this.status = code.getStatus();
    }

    public HttpStatus getStatus() {
        return status;
    }
}
