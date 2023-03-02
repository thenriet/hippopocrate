package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import co.simplon.hippopocrate.model.Bed;

/**
 * @author tom
 *
 * Repository containing CRUD methods for Bed
 */
@Component 
public interface BedRepository extends JpaRepository<Bed, Long> {
	
}
