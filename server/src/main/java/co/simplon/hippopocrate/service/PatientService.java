package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;
	
	public List<Patient> findAllPatients() {
		List<Patient> patients = patientRepository.findAll();
		return patients;
	}

}
