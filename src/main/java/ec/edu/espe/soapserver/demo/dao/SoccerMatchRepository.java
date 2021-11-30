package ec.edu.espe.soapserver.demo.dao;

import ec.edu.espe.soapserver.demo.model.SoccerMatch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface SoccerMatchRepository extends JpaRepository<SoccerMatch, Long> {
    List<SoccerMatch> findByDateAfter(Date now);
}
