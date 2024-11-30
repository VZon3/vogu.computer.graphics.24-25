package org.example.rest;

import java.io.Serializable;

public class BaseResponse {

    public final Boolean success;
    public final Object body;
    public final ErrorRs error;

    private BaseResponse( Boolean success, Object body, ErrorRs error ) {
        this.success = success;
        this.body = body;
        this.error = error;
    }

    public static BaseResponse ok( Object body ) {
        return new BaseResponse( true, body, null );
    }

    public static BaseResponse fail( ErrorRs error ) {
        return new BaseResponse( false, null, error );
    }
}
