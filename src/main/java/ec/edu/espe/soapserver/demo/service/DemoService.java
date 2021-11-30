package ec.edu.espe.soapserver.demo.service;

import com.gjcasanova.soap.GetEchoRequest;
import ec.edu.espe.soapserver.demo.dao.EchoRepository;
import ec.edu.espe.soapserver.demo.model.Echo;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Builder
@Service
public class DemoService {
    @Autowired
    private final EchoRepository echoRepository;

    public void create(String echoType, String message){
        Echo echoToSave = new Echo();
        echoToSave.setEchoType(echoType);
        echoToSave.setMessage(message);
        echoRepository.save(echoToSave);
    }
}
