package org.example.rest;


import org.example.exeption.DemoException;
import org.example.logic.DemoService;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class DemoEndpoint {

    private final DemoService demoService;

    @Autowired
    public DemoEndpoint( DemoService demoService ) {
        this.demoService = demoService;
    }

    @GetMapping( "/student/select/all" )
    public ResponseEntity<?> getStudentAll() throws DemoException {
        return ResponseEntity.ok( BaseResponse.ok( demoService.getStudentAll() ) );
    }

    @PostMapping( "/student/add" )
    public ResponseEntity<?> studentAdd( @RequestBody StudentRq studentRq ) {
        demoService.studentAdd( studentRq );
        return ResponseEntity.ok().build();
    }

    @PostMapping( "/description/add" )
    public ResponseEntity<BaseResponse> descriptionAdd( @RequestBody DescriptionRq descriptionRq ) throws DemoException {
        demoService.descriptionAdd( descriptionRq );
        return ResponseEntity.ok().build();
    }

    @PostMapping( "/description/delete" )
    public ResponseEntity<BaseResponse> descriptionDelete( @RequestBody DescriptionRq descriptionRq ) {
        demoService.descriptionDelete( descriptionRq );
        return ResponseEntity.ok().build();
    }

}
