package org.example.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ErrorRs implements Serializable {

    public final String message;

    public ErrorRs( @JsonProperty( "message" ) String message ) {
        this.message = message;
    }
}
