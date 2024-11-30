package org.example.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exeption.DemoException;
import org.example.exeption.DemoExceptionCode;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

public class HttpSourceServiceImpl implements DemoService{

    private final RestClient restClient = RestClient.create();

    private final ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public List<StudentRs> getStudentAll() throws DemoException {
        List<StudentRs> studentRsList = new ArrayList<>();
        List resList = restClient.get()
                                 .uri( "http://26.141.131.233:8080/student/select/all" )
                                 .retrieve()
                                 .body( List.class );
        if( resList == null )
            throw new DemoException( DemoExceptionCode.UNEXPECTED_SERVICE_ERROR );
        resList.forEach( bodyEl ->  studentRsList.add( objectMapper.convertValue( bodyEl, StudentRs.class ) ) );

        return studentRsList;
    }

    @Override
    public void studentAdd( StudentRq studentRq ) {
        restClient.post()
                  .uri( "http://26.141.131.233:8080/student/add" )
                  .body( studentRq )
                  .retrieve()
                  .toBodilessEntity();
    }

    @Override
    public void descriptionAdd( DescriptionRq descriptionRq ) {
        restClient.post()
                .uri( "http://26.141.131.233:8080/description/add" )
                .body( descriptionRq )
                .retrieve()
                .onStatus( status -> status.equals( HttpStatus.BAD_GATEWAY ), ( rq, rs ) -> {
                    throw new RuntimeException( rs.getBody().toString() );
                } )
                .toBodilessEntity();
    }

    @Override
    public void descriptionDelete( DescriptionRq descriptionRq ) {
        restClient.post()
                .uri( "http://26.141.131.233:8080/description/delete" )
                .body( descriptionRq )
                .retrieve()
                .toBodilessEntity();
    }
}
