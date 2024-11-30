package org.example.logic;

import org.example.exeption.DemoException;
import org.example.exeption.DemoExceptionCode;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DemoServiceImpl implements DemoService {

    private final Map<Integer, StudentRq> studentStorage = new HashMap<>();

    @Override
    public List<StudentRs> getStudentAll() {
        return studentStorage.keySet().stream()
                                      .map( key -> new StudentRs( key,
                                                                  studentStorage.get( key ).name,
                                                                  studentStorage.get( key ).age,
                                                                  studentStorage.get( key ).nickname,
                                                                  studentStorage.get( key ).description ) )
                                      .collect( Collectors.toList() ) ;
    }

    @Override
    public void studentAdd( StudentRq studentRq ) {
        studentStorage.put( studentStorage.keySet().size() + 1, studentRq );
    }

    @Override
    public void descriptionAdd( DescriptionRq descriptionRq ) throws DemoException {
        if( !studentStorage.containsKey( descriptionRq.id ) )
            throw new DemoException( DemoExceptionCode.STUDENT_NOT_EXIST, descriptionRq.id );
        StudentRq studentRq = studentStorage.get( descriptionRq.id );
        studentRq.description.addAll( descriptionRq.description );
    }

    @Override
    public void descriptionDelete( DescriptionRq descriptionRq ) {
        StudentRq studentRq = studentStorage.get( descriptionRq.id );
        if( studentRq != null )
            studentRq.description.removeAll( descriptionRq.description );
    }
}
