package co.simplon.hippopocrate.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository pr;
	@Autowired
	private BedServiceImpl bsi;

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

	public PatientDTO findPatientById(long patientId) {
		Patient patient = pr.findById(patientId).get();
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(patient.getId());
		patientDTO.setFirstname(patient.getFirstname());
		patientDTO.setLastname(patient.getLastname());
		patientDTO.setBirthdate(patient.getBirthdate());
		patientDTO.setAddress(patient.getAddress());
		patientDTO.setDateIn(patient.getDateIn());
		patientDTO.setDateOut(patient.getDateOut());
		patientDTO.setBedId(patient.getBed().getId());
		patientDTO.setBedNumber(patient.getBed().getNumber());
		patientDTO.setRoomId(patient.getBed().getRoom().getId());
		patientDTO.setRoomNumber(patient.getBed().getRoom().getNumber());
		patientDTO.setServiceId(patient.getBed().getRoom().getService().getId());
		patientDTO.setServiceName(patient.getBed().getRoom().getService().getName());
		return patientDTO;
	}

	@Override
	public Patient updatePatient(PatientDTO patientDTO, long patientId) {
		// TODO Auto-generated method stub
		Patient patientInDB = pr.findById(patientId).get();

		if (Objects.nonNull(patientDTO.getFirstname()) && !"".equalsIgnoreCase(patientDTO.getFirstname())) {
			patientInDB.setFirstname(patientDTO.getFirstname());
		}

		if (Objects.nonNull(patientDTO.getLastname()) && !"".equalsIgnoreCase(patientDTO.getLastname())) {
			patientInDB.setLastname(patientDTO.getLastname());
		}

		if (Objects.nonNull(patientDTO.getBirthdate())) {
			patientInDB.setBirthdate(patientDTO.getBirthdate());
		}

		if (Objects.nonNull(patientDTO.getAddress()) && !"".equalsIgnoreCase(patientDTO.getAddress())) {
			patientInDB.setAddress(patientDTO.getAddress());
		}

		if (patientInDB.getBed() != null) {
			patientInDB.getBed().setOccupied(false);

		}
		patientInDB.setBed(bsi.findBedById(patientDTO.getBedId()));
		patientInDB.getBed().setOccupied(true);

		return pr.save(patientInDB);
	}

	@Override
	public void deletePatientById(long patientId) {
		// TODO Auto-generated method stub
		
	}

	public PatientDTO createPatientDTOFromDB(long id) {
		Patient patient = pr.findById(id).get();
		PatientDTO patientDTO = new PatientDTO();
		patientDTO.setId(patient.getId());
		patientDTO.setFirstname(patient.getFirstname());
		patientDTO.setLastname(patient.getLastname());
		patientDTO.setBirthdate(patient.getBirthdate());
		patientDTO.setAddress(patient.getAddress());
		patientDTO.setDateIn(patient.getDateIn());
		patientDTO.setDateOut(patient.getDateOut());
		if (patient.getBed() != null) {
			patientDTO.setBedId(patient.getBed().getId());
			patientDTO.setRoomId(patient.getBed().getRoom().getId());
			patientDTO.setServiceId(patient.getBed().getRoom().getService().getId());
			patientDTO.setServiceName(patient.getBed().getRoom().getService().getName());
			patientDTO.setRoomNumber(patient.getBed().getRoom().getNumber());
			patientDTO.setBedNumber(patient.getBed().getNumber());
		}
		return patientDTO;
	}

	public List<PatientDTO> createPatientsDTOFromDB() {
		List<PatientDTO> patientsDTOList = new ArrayList<PatientDTO>();
		List<Patient> patientsInDB = this.fetchPatientList();
		for (int i = 0; i < patientsInDB.size(); i++) {
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setId(patientsInDB.get(i).getId());
			patientDTO.setFirstname(patientsInDB.get(i).getFirstname());
			patientDTO.setLastname(patientsInDB.get(i).getLastname());
			patientDTO.setBirthdate(patientsInDB.get(i).getBirthdate());
			patientDTO.setAddress(patientsInDB.get(i).getAddress());
			patientDTO.setDateIn(patientsInDB.get(i).getDateIn());
			patientDTO.setDateOut(patientsInDB.get(i).getDateOut());
			if (patientsInDB.get(i).getBed() != null) {
				patientDTO.setBedId(patientsInDB.get(i).getBed().getId());
				patientDTO.setRoomId(patientsInDB.get(i).getBed().getRoom().getId());
				patientDTO.setServiceId(patientsInDB.get(i).getBed().getRoom().getService().getId());
				patientDTO.setServiceName(patientsInDB.get(i).getBed().getRoom().getService().getName());
				patientDTO.setRoomNumber(patientsInDB.get(i).getBed().getRoom().getNumber());
				patientDTO.setBedNumber(patientsInDB.get(i).getBed().getNumber());
			}

			patientsDTOList.add(patientDTO);
		}
		return patientsDTOList;

	}

	public List<PatientDTO> fetchPatientsByService(int id) {
		List<PatientDTO> patientsDTOList = new ArrayList<PatientDTO>();
		List<Patient> patientsInDB = this.fetchPatientList();
		for (int i = 0; i < patientsInDB.size(); i++) {
			PatientDTO patientDTO = new PatientDTO();
			patientDTO.setId(patientsInDB.get(i).getId());
			patientDTO.setFirstname(patientsInDB.get(i).getFirstname());
			patientDTO.setLastname(patientsInDB.get(i).getLastname());
			patientDTO.setBirthdate(patientsInDB.get(i).getBirthdate());
			patientDTO.setAddress(patientsInDB.get(i).getAddress());
			patientDTO.setDateIn(patientsInDB.get(i).getDateIn());
			patientDTO.setDateOut(patientsInDB.get(i).getDateOut());
			if (patientsInDB.get(i).getBed() != null) {
				patientDTO.setBedId(patientsInDB.get(i).getBed().getId());
				patientDTO.setRoomId(patientsInDB.get(i).getBed().getRoom().getId());
				patientDTO.setServiceId(patientsInDB.get(i).getBed().getRoom().getService().getId());
				patientDTO.setServiceName(patientsInDB.get(i).getBed().getRoom().getService().getName());
				patientDTO.setRoomNumber(patientsInDB.get(i).getBed().getRoom().getNumber());
				patientDTO.setBedNumber(patientsInDB.get(i).getBed().getNumber());
			}
			if (patientDTO.getServiceId() == id) {
				patientsDTOList.add(patientDTO);
			}
		}
		return patientsDTOList;

	}

	public void savePatientDTO(PatientDTO patientDTO) {
		// TODO Auto-generated method stub
		Patient patient = new Patient();

		patient.setId(patientDTO.getId());
		patient.setFirstname(patientDTO.getFirstname());
		patient.setLastname(patientDTO.getLastname());
		patient.setBirthdate(patientDTO.getBirthdate());
		patient.setAddress(patientDTO.getAddress());
		patient.setDateIn(patientDTO.getDateIn());
		patient.setBed(bsi.findBedById(patientDTO.getBedId()));
		Bed bed = bsi.findBedById(patientDTO.getBedId());
		bed.setOccupied(true);
		bsi.updateBed(bed, patientDTO.getBedId());

		pr.save(patient);
	}

	public Patient exitPatient(PatientDTO patientDTO, long patientId) {
		Patient patientInDB = pr.findById(patientId).get();

		if (Objects.nonNull(patientDTO.getFirstname()) && !"".equalsIgnoreCase(patientDTO.getFirstname())) {
			patientInDB.setFirstname(patientDTO.getFirstname());
		}

		if (Objects.nonNull(patientDTO.getLastname()) && !"".equalsIgnoreCase(patientDTO.getLastname())) {
			patientInDB.setLastname(patientDTO.getLastname());
		}

		if (Objects.nonNull(patientDTO.getBirthdate())) {
			patientInDB.setBirthdate(patientDTO.getBirthdate());
		}

		if (Objects.nonNull(patientDTO.getAddress()) && !"".equalsIgnoreCase(patientDTO.getAddress())) {
			patientInDB.setAddress(patientDTO.getAddress());
		}

		patientInDB.getBed().setOccupied(false);
		patientInDB.setBed(null);

		return pr.save(patientInDB);
	}

	// Méthode pour récupérer les commentaires suivi d'un patient
	public List<CommentaryDTO> findCommentary(long patient_Id) {
		List<CommentaryDTO> commentariesDTO = new ArrayList<CommentaryDTO>();
		List<Commentary> commentaries = pr.findById(patient_Id).get().getCommentaries();
		for (int i = 0; i < commentaries.size(); i++) {
			CommentaryDTO commentaryDTO = new CommentaryDTO();
			commentaryDTO.setId(commentaries.get(i).getId());
			commentaryDTO.setCommentary((commentaries.get(i).getCommentary()));
			commentaryDTO.setUserId(commentaries.get(i).getUser().getId());
			commentaryDTO.setUserName((commentaries.get(i).getUser().getName()));
			commentaryDTO.setPatientId(patient_Id);
			commentariesDTO.add(commentaryDTO);
		}
		return commentariesDTO;
	}

}