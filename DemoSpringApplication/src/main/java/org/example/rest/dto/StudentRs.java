package org.example.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class StudentRs implements Serializable {

    public final Integer id;
    public final String name;
    public final Integer age;
    public final String nickname;
    public final List<String> description;


    public StudentRs( @JsonProperty( "id" ) Integer id,
                      @JsonProperty( "name" ) String name,
                      @JsonProperty( "age" ) Integer age,
                      @JsonProperty( "nickname" ) String nickname,
                      @JsonProperty( "description" ) List<String> description ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nickname = nickname;
        this.description = description;
    }

    public StudentRs( Integer id, StudentRq studentRq ) {
        this.id = id;
        this.name = studentRq.name;
        this.age = studentRq.age;
        this.nickname = studentRq.nickname;
        this.description = studentRq.description;
    }
}
