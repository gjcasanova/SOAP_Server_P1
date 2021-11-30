package ec.edu.espe.soapserver.demo.service;

import com.gjcasanova.soap.GetAvailableMatchResponse;
import com.gjcasanova.soap.Match;
import ec.edu.espe.soapserver.demo.dao.SoccerMatchRepository;
import ec.edu.espe.soapserver.demo.model.SoccerMatch;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@Service
public class SoccerMatchService {
    @Autowired
    private final SoccerMatchRepository soccerMatchRepository;

    public GetAvailableMatchResponse getAllMatches(){
        GetAvailableMatchResponse result = new GetAvailableMatchResponse();
        List<SoccerMatch> matches = soccerMatchRepository.findByDateAfter(Calendar.getInstance().getTime());
        for(SoccerMatch m : matches){
            Match e = new Match();
            e.setDate(m.getDate().toString());
            e.setMatchId(m.getId().intValue());
            e.setLocalTeam(m.getLocalTeam());
            e.setVisitingTeam(m.getVisitingTeam());
            e.setSite(m.getSite());
            result.getMatch().add(e);
        }
        return result;
    }
}
