package org.example.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

import java.util.List;

public class DescriptionRq implements Serializable {

    public final Integer id;
    public final List<String> description;


    public DescriptionRq( @JsonProperty( "id" ) Integer id,
                          @JsonProperty( "description" ) List<String> description ) {
        this.id = id;
        this.description = description;
    }
}
