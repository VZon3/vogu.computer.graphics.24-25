package org.example.behavior;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.configuration.ExternalServiceProperties;
import org.example.rest.dto.DescriptionRq;
import org.example.rest.dto.StudentRq;
import org.example.rest.dto.StudentRs;
import org.example.rest.exeption.DemoException;
import org.example.rest.exeption.DemoExceptionCode;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.stream.Collectors;

public class ExternalDemoServiceImpl implements DemoService {

    private final String baseUrl;

    private final RestClient restClient = RestClient.create();

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ExternalDemoServiceImpl( ExternalServiceProperties serviceProperties ) {
        this.baseUrl = "http://" + serviceProperties.getHost() + ":" + serviceProperties.getPort();
    }

    @Override
    public List<StudentRs> getStudentAll() throws DemoException {
        List<?> resList = sendRequest( HttpMethod.GET, baseUrl + GET_ALL_STUDENT, null, List.class );
        return validateAndGetStudentList( resList );
    }

    private <TRes> TRes sendRequest( HttpMethod method, String uri, Object body, Class<TRes> resClass ) {
        RestClient.RequestBodySpec request = restClient.method( method )
                                                       .uri( uri );
        if( body != null )
            request.body( body );
        return request.retrieve()
                      .onStatus( status -> !status.equals( HttpStatus.OK ),
                                 ( rq, rs ) -> {
                                        throw new DemoException( DemoExceptionCode.UNEXPECTED_EXTERNAL_SERVICE_ERROR,
                                        rs.getBody().toString() );
                                                }
                                )
                      .body( resClass );
    }

    private List<StudentRs> validateAndGetStudentList( List<?> listFromResponse ) {
        if( listFromResponse == null )
            throw new DemoException( DemoExceptionCode.UNEXPECTED_EXTERNAL_SERVICE_ERROR, "Получен путой список" );
        return listFromResponse.stream()
                               .map( s -> objectMapper.convertValue( s, StudentRs.class ) )
                               .collect( Collectors.toList() );
    }

    @Override
    public void studentAdd( StudentRq studentRq ) {
        sendRequest( HttpMethod.POST, baseUrl + ADD_STUDENT, studentRq, String.class );
    }

    @Override
    public void descriptionAdd( DescriptionRq descriptionRq ) {
        sendRequest( HttpMethod.POST, baseUrl + ADD_DESCRIPTION, descriptionRq, String.class );
    }

    @Override
    public void descriptionDelete( DescriptionRq descriptionRq ) {
        sendRequest( HttpMethod.POST, baseUrl + DELETE_DESCRIPTION, descriptionRq, String.class );
    }
}
