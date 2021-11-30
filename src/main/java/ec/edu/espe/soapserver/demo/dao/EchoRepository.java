package ec.edu.espe.soapserver.demo.dao;

import ec.edu.espe.soapserver.demo.model.Echo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EchoRepository extends JpaRepository<Echo, Long> {
}
