package ec.edu.espe.soapserver.demo.controller;

import com.gjcasanova.soap.*;
import ec.edu.espe.soapserver.demo.service.DemoService;
import ec.edu.espe.soapserver.demo.service.LocationMatchService;
import ec.edu.espe.soapserver.demo.service.SoccerMatchService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Data
@Endpoint
@Slf4j
public class DemoControllerEndpoint {
    public static final String NAMESPACE_URI = "http://gjcasanova.com/soap";

    @Autowired
    private final DemoService demoService;

    @Autowired
    private final LocationMatchService locationMatchService;

    @Autowired
    private final SoccerMatchService soccerMatchService;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEchoRequest")
    @ResponsePayload
    public GetEchoResponse getEchoResponse(@RequestPayload GetEchoRequest request){
        GetEchoResponse response=new GetEchoResponse();
        response.setType(request.getEchoType());
        response.setMessage("It works!");
        try {
            demoService.create(response.getType(), response.getMessage());
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAvailableMatchRequest")
    @ResponsePayload
    public GetAvailableMatchResponse getAvailableMatchResponse(@RequestPayload GetAvailableMatchRequest request){
        GetAvailableMatchResponse response=new GetAvailableMatchResponse();
        try {
            response = soccerMatchService.getAllMatches();
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLocalitiesRequest")
    @ResponsePayload
    public GetLocalitiesResponse getLocalitiesResponse(@RequestPayload GetLocalitiesRequest request){
        GetLocalitiesResponse response=new GetLocalitiesResponse();
        try {
            response = locationMatchService.getMatchLocalities((long)request.getMatchId());
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "buyLocationRequest")
    @ResponsePayload
    public GetLocalitiesResponse buyLocationRequest(@RequestPayload BuyLocationRequest request){
        GetLocalitiesResponse response=new GetLocalitiesResponse();
        try {
            response = locationMatchService.buyLocation((long)request.getLocationId());
        }catch (Exception ex){
            log.error(ex.getMessage());
        }
        return response;
    }
}
