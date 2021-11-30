package ec.edu.espe.soapserver.demo.controller;

import com.gjcasanova.soap.GetEchoRequest;
import com.gjcasanova.soap.GetEchoResponse;
import ec.edu.espe.soapserver.demo.service.DemoService;
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
}
