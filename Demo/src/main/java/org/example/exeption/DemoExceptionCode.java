package org.example.exeption;

import org.springframework.http.HttpStatus;

public enum DemoExceptionCode {

    STUDENT_NOT_EXIST( HttpStatus.BAD_REQUEST, "Студента с id %s не существует" ),

    UNEXPECTED_SERVICE_ERROR( HttpStatus.INTERNAL_SERVER_ERROR, "Неизвестная ошибка сервера" ),

    EXTERNAL_SERVICE_ERROR( HttpStatus.BAD_GATEWAY, "Студента с id %s не существует" );

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
