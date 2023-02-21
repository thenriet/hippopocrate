package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hippopocrate.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}
