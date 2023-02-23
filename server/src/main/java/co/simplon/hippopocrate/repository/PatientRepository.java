package co.simplon.hippopocrate.repository;

import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.Patient;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
