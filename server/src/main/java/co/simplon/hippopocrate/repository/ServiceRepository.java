package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import co.simplon.hippopocrate.model.ServiceHippo;

@Component 
public interface ServiceRepository extends JpaRepository<ServiceHippo, Long> {

}
