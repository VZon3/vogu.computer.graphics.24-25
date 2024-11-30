package org.example.behavior;

import org.example.rest.exeption.DemoException;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;

import java.util.List;

public interface DemoService {

    String GET_ALL_STUDENT = "/student/select/all";
    String ADD_STUDENT = "/student/add";
    String ADD_DESCRIPTION = "/description/add";
    String DELETE_DESCRIPTION = "/description/delete";

    public List<StudentRs> getStudentAll() throws DemoException;

    public void studentAdd( StudentRq studentRq );

    public void descriptionAdd( DescriptionRq descriptionRq ) throws DemoException;

    public void descriptionDelete( DescriptionRq descriptionRq );
}
