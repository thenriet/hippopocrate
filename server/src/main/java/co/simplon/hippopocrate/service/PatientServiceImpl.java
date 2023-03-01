package co.simplon.hippopocrate.service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.repository.CommentaryRepository;
import co.simplon.hippopocrate.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return pr.save(patient);
	}

	@Override
	public List<Patient> fetchPatientList() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	public Patient findPatientById(long id) {
		return pr.findById(id).get();
	}

	@Override
	public Patient updatePatient(Patient patient, int id) {
		// TODO Auto-generated method stub
		Patient patientInDB = pr.findById((long) id).get();

		if (Objects.nonNull(patient.getFirstname()) && !"".equalsIgnoreCase(patient.getFirstname())) {
			patientInDB.setFirstname(patient.getFirstname());
		}

		if (Objects.nonNull(patient.getLastname()) && !"".equalsIgnoreCase(patient.getLastname())) {
			patientInDB.setLastname(patient.getLastname());
		}

		if (Objects.nonNull(patient.getBirthdate())) {
			patientInDB.setBirthdate(patient.getBirthdate());
		}

		if (Objects.nonNull(patient.getBed_id())) {
			patientInDB.setBed_id(patient.getBed_id());
		}

		if (Objects.nonNull(patient.getAddress()) && !"".equalsIgnoreCase(patient.getAddress())) {
			patientInDB.setAddress(patient.getAddress());
		}

		return pr.save(patientInDB);
	}

	@Override
	public void deletePatientById(int id) {
	}
		
	public Set<Commentary> findCommentary(long patient_Id) {
		 Set<Commentary> commentaries = pr.findById(patient_Id).get().getCommentaries();
		 System.out.println(commentaries);
		 return commentaries;
	}
	
//	public Commentary addCommentary(Commentary commentary, long patient_Id) {
//		return pr.findById(patient_Id).save(commentary);
//
//	}
	
}