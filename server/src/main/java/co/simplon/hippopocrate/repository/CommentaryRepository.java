package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;

@Repository
public interface CommentaryRepository extends JpaRepository<Commentary, Long>{
	Commentary findbyPatientId(int patient_id);
}