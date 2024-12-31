package org.example.behavior;

import org.example.rest.exeption.DemoException;
import org.example.rest.exeption.DemoExceptionCode;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class DemoServiceImpl implements DemoService {

    private final Map<Integer, StudentRq> studentStorage = new ConcurrentHashMap<>();

    @Override
    public List<StudentRs> getStudentAll() {
        return studentStorage.keySet().stream()
                                      .map( id -> new StudentRs( id, studentStorage.get( id ) ) )
                                      .collect( Collectors.toList() ) ;
    }

    @Override
    public void studentAdd( StudentRq studentRq ) {
        studentStorage.put( studentStorage.keySet().size() + 1, studentRq );
    }

    @Override
    public void descriptionAdd( DescriptionRq descriptionRq ) throws DemoException {
        validateDescriptionRq( descriptionRq );
        StudentRq studentRq = studentStorage.get( descriptionRq.id );
        studentRq.description.addAll( descriptionRq.description );
    }

    private void validateDescriptionRq( DescriptionRq descriptionRq ) throws DemoException {
        if( !studentStorage.containsKey( descriptionRq.id ) )
            throw new DemoException( DemoExceptionCode.STUDENT_NOT_EXIST, descriptionRq.id );
    }

    @Override
    public void descriptionDelete( DescriptionRq descriptionRq ) {
        StudentRq studentRq = studentStorage.get( descriptionRq.id );
        if( studentRq != null )
            studentRq.description.removeAll( descriptionRq.description );
    }
}
