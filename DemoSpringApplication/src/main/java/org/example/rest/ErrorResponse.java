package org.example.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorResponse implements Serializable {

    public final String message;

    public ErrorResponse( @JsonProperty( "message" ) String message ) {
        this.message = message;
    }
}
