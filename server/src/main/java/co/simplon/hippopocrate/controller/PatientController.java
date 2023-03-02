package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.service.PatientServiceImpl;

/**
 * @author tom
 * Controller for Patient used for REST api
 */
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping("api/")
public class PatientController {
	
	@Autowired
	private  PatientServiceImpl psi;
	
    /**
     * @return a list of PatientsDTO
     */
    @GetMapping("patients")
	public List<PatientDTO> fetchPatientsList() {
		return psi.createPatientsDTOFromDB();
	}
 
    /**
     * @param id is the patientId from the database
     * @return a single one Patient entity
     */
    @GetMapping("patients/{id}")
    public PatientDTO findById(@PathVariable long id) {
    	return psi.createPatientDTOFromDB(id);
    }
    
    /**
     * @param patientDTO is a PatientDTO object which is going to be used to create a Patient object
     */
    @PostMapping("patients")
    void addPatient(@RequestBody PatientDTO patientDTO) {
    	psi.savePatientDTO(patientDTO);
    }
    
    /**
     * @param id is the id of the Patient which is going to be updated
     * @return a single one Patient entity
     */
    @GetMapping("updatepatient/{id}")
	public Patient updateById(@PathVariable long id) {
		return psi.findPatientById(id);
	}
	
	/**
	 * @param patientDTO is a PatientDTO object which is used to update a Patient in DB
	 * @param id is the id of the Patient object which is going to be updated
	 */
	@PutMapping("updatepatient/{id}")
	void updatePatient (@RequestBody PatientDTO patientDTO, @PathVariable long id) {
		psi.updatePatient(patientDTO, id);
	}
	
	/**
	 * @param patientDTO is a PatientDTO object which is used to update a Patient in DB
	 * @param id is the id of the Patient object which is going to be updated as 'exited'
	 */
	@PutMapping("exitpatient/{id}")
	void exitPatient (@RequestBody PatientDTO patientDTO, @PathVariable long id) {
		psi.exitPatient(patientDTO, id);
	}

}
