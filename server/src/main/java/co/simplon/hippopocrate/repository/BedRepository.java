package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hippopocrate.model.Bed;

public interface BedRepository extends JpaRepository<Bed, Long> {
	
}
