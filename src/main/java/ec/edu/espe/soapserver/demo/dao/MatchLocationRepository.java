package ec.edu.espe.soapserver.demo.dao;

import ec.edu.espe.soapserver.demo.model.MatchLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchLocationRepository extends JpaRepository<MatchLocation, Long> {
    List<MatchLocation> findByMatch_Id(Long matchId);
}
