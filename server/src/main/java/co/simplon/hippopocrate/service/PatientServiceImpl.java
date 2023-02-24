package co.simplon.hippopocrate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Patient;
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
	
	public Patient findPatientById(long patientId) {
		return pr.findById(patientId).get();
	}
	

	@Override
	public Patient updatePatient(Patient patient, long patientId) {
		// TODO Auto-generated method stub
		Patient patientInDB = pr.findById(patientId).get();
		
		if (Objects.nonNull(patient.getFirstname()) && !"".equalsIgnoreCase(patient.getFirstname())) {
			patientInDB.setFirstname(patient.getFirstname());
        }
        
        if (Objects.nonNull(patient.getLastname()) && !"".equalsIgnoreCase(patient.getLastname())) {
        	patientInDB.setLastname(patient.getLastname());
        }
        
  
        if (Objects.nonNull(patient.getBirthdate()) ) {
        	patientInDB.setBirthdate(patient.getBirthdate());
        }
        
        if (Objects.nonNull(patient.getBed())) {
        	patientInDB.setBed(patient.getBed());
        }
        
        if (Objects.nonNull(patient.getAddress()) && !"".equalsIgnoreCase(patient.getAddress())) {
        	patientInDB.setAddress(patient.getAddress());
        }
  
        return pr.save(patientInDB);
    }

	@Override
	public void deletePatientById(long patientId) {
		// TODO Auto-generated method stub
		
	}
	
	public PatientDTO createPatientDTOFromDB(long id){
		Patient patient = pr.findById(id).get();
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(patient.getId()); 
		patientDTO.setFirstname(patient.getFirstname()); 
		patientDTO.setLastname(patient.getLastname());
		patientDTO.setBirthdate(patient.getBirthdate());
		patientDTO.setAddress(patient.getAddress());
		patientDTO.setDate_in(patient.getDate_in());
		patientDTO.setDate_out(patient.getDate_out());
		patientDTO.setBed_id(patient.getBed().getId());
		patientDTO.setRoom_id(patient.getBed().getRoom().getId());
		patientDTO.setService_id(patient.getBed().getRoom().getService().getId());
		return patientDTO;
	}
	
	public List<PatientDTO> createPatientsDTOFromDB() {
		List<PatientDTO> patientsDTOList = new ArrayList<PatientDTO>(); 
		List <Patient> patientsInDB = this.fetchPatientList();
		for (int i = 0; i < patientsInDB.size(); i++) {
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setId(patientsInDB.get(i).getId()); 
			patientDTO.setFirstname(patientsInDB.get(i).getFirstname()); 
			patientDTO.setLastname(patientsInDB.get(i).getLastname());
			patientDTO.setBirthdate(patientsInDB.get(i).getBirthdate());
			patientDTO.setAddress(patientsInDB.get(i).getAddress());
			patientDTO.setDate_in(patientsInDB.get(i).getDate_in());
			patientDTO.setDate_out(patientsInDB.get(i).getDate_out());
			patientDTO.setBed_id(patientsInDB.get(i).getBed().getId());
			patientDTO.setRoom_id(patientsInDB.get(i).getBed().getRoom().getId());
			patientDTO.setService_id(patientsInDB.get(i).getBed().getRoom().getService().getId());
			patientsDTOList.add(patientDTO);
		}
		return patientsDTOList;
			
	}

}
