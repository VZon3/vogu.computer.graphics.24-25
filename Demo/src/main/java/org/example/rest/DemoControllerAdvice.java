package org.example.rest;

import org.example.rest.exeption.DemoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DemoControllerAdvice {

    @ExceptionHandler( DemoException.class )
    public ResponseEntity<?> handleDemoException( DemoException exception ){
        return ResponseEntity.status( exception.getStatus() )
                             .body( BaseResponse.fail( new ErrorResponse( exception.getMessage() ) ) );
    }

    @ExceptionHandler( Exception.class )
    public ResponseEntity<?> handleException( Exception exception ){
        return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR )
                             .body( BaseResponse.fail( new ErrorResponse( exception.getMessage() ) ) );
    }
}
