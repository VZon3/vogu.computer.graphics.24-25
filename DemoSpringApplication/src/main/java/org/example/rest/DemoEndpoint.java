package org.example.rest;

import org.example.behavior.DemoService;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.example.behavior.DemoService.*;

@Controller
public class DemoEndpoint {

    private final DemoService demoService;

    @Autowired
    public DemoEndpoint( DemoService demoService ) {
        this.demoService = demoService;
    }

    @GetMapping( GET_ALL_STUDENT )
    public ResponseEntity<?> getStudentAll(){
        return ResponseEntity.ok( BaseResponse.ok( demoService.getStudentAll() ) );
    }

    @PostMapping( ADD_STUDENT )
    public ResponseEntity<?> studentAdd( @RequestBody StudentRq studentRq ) {
        demoService.studentAdd( studentRq );
        return ResponseEntity.ok().build();
    }

    @PostMapping( ADD_DESCRIPTION )
    public ResponseEntity<?> descriptionAdd( @RequestBody DescriptionRq descriptionRq ) {
        demoService.descriptionAdd( descriptionRq );
        return ResponseEntity.ok().build();
    }

    @PostMapping( DELETE_DESCRIPTION )
    public ResponseEntity<?> descriptionDelete( @RequestBody DescriptionRq descriptionRq ) {
        demoService.descriptionDelete( descriptionRq );
        return ResponseEntity.ok().build();
    }

}
