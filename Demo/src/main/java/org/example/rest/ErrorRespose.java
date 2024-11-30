package org.example.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorRespose implements Serializable {

    public final String message;

    public ErrorRespose( @JsonProperty( "message" ) String message ) {
        this.message = message;
    }
}
