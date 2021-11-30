package ec.edu.espe.soapserver.demo.service;

import com.gjcasanova.soap.GetLocalitiesResponse;
import com.gjcasanova.soap.Location;
import ec.edu.espe.soapserver.demo.dao.MatchLocationRepository;
import ec.edu.espe.soapserver.demo.model.MatchLocation;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Builder
@Service
public class LocationMatchService {
    @Autowired
    private final MatchLocationRepository matchLocationRepository;

    public GetLocalitiesResponse getMatchLocalities(Long id){
        GetLocalitiesResponse result = new GetLocalitiesResponse();
        List<MatchLocation> locations = matchLocationRepository.findByMatch_Id(id);
        for(MatchLocation l : locations){
            Location e = new Location();
            e.setLocationId(l.getId().intValue());
            e.setAvailability(l.getAvailability());
            e.setCode(l.getCode());
            e.setPrice(l.getPrice());
            result.getLocation().add(e);
        }
        return result;
    }

    public GetLocalitiesResponse buyLocation(Long id){
        MatchLocation location = matchLocationRepository.getById(id);
        GetLocalitiesResponse response = new GetLocalitiesResponse();
        if(location.getAvailability()>0){
            location.setAvailability(location.getAvailability()-1);
            matchLocationRepository.save(location);
            Location l = new Location();
            l.setCode(location.getCode());
            l.setLocationId(location.getId().intValue());
            l.setPrice(location.getPrice());
            l.setAvailability(location.getAvailability());
            response.getLocation().add(l);
            return response;
        }else{
            throw new IllegalArgumentException("Not available");
        }
    }
}
