package org.example.rest.exeption;

import org.springframework.http.HttpStatus;

public enum DemoExceptionCode {

    STUDENT_NOT_EXIST( HttpStatus.BAD_REQUEST, "Студента с id %s не существует" ),

    UNEXPECTED_EXTERNAL_SERVICE_ERROR( HttpStatus.INTERNAL_SERVER_ERROR, "Неизвестная ошибка внешнего сервера: %s" );

    private final HttpStatus status;

    private final String message;

    DemoExceptionCode( HttpStatus status, String message ) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
