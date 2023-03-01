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

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RestController
@RequestMapping("api/")
public class PatientController {
	
	@Autowired
	private  PatientServiceImpl psi;
	
    @GetMapping("patients")
	public List<PatientDTO> fetchPatientsList() {
		return psi.createPatientsDTOFromDB();
	}
 
    @GetMapping("patients/{id}")
    public PatientDTO findById(@PathVariable long id) {
    	return psi.createPatientDTOFromDB(id);
    }
    
    @PostMapping("patients")
    void addPatient(@RequestBody PatientDTO patientDTO) {
    	psi.savePatientDTO(patientDTO);
    }
    
    @GetMapping("updatepatient/{id}")
	public Patient updateById(@PathVariable long id) {
		return psi.findPatientById(id);
	}
	
	@PutMapping("updatepatient/{id}")
	void updatePatient (@RequestBody PatientDTO patientDTO, @PathVariable long id) {
		psi.updatePatient(patientDTO, id);
	}

}
