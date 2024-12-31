package org.example.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class StudentRq implements Serializable {


    public final String name;
    public final Integer age;
    public final String nickname;
    public final List<String> description;


    public StudentRq( @JsonProperty( "name" ) String name,
                      @JsonProperty( "age" ) Integer age,
                      @JsonProperty( "nickname" ) String nickname,
                      @JsonProperty( "description" ) List<String> description ) {
        this.name = name;
        this.age = age;
        this.nickname = nickname;
        this.description = description;
    }
}
