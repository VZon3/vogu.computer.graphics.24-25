package org.example.logic;

import org.example.exeption.DemoException;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;

import java.util.List;

public interface DemoService {

    public List<StudentRs> getStudentAll() throws DemoException;

    public void studentAdd( StudentRq studentRq );

    public void descriptionAdd( DescriptionRq descriptionRq ) throws DemoException;

    public void descriptionDelete( DescriptionRq descriptionRq );
}
