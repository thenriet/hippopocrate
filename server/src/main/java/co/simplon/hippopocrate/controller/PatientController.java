package co.simplon.hippopocrate.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.dto.CommentaryDTO;
import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.service.PatientServiceImpl;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class PatientController {

	@Autowired
	private PatientServiceImpl psi;

	@GetMapping("patients")
	public List<PatientDTO> fetchPatientsList() {
		return psi.createPatientsDTOFromDB();
	}

	@PostMapping("patients")
	void addPatient(@RequestBody PatientDTO patientDTO) {
		psi.savePatientDTO(patientDTO);
	}

	@GetMapping("patients/{id}")
	public PatientDTO findById(@PathVariable long id) {
		return psi.findPatientById(id);
	}

	@GetMapping("services/{id}/patients")
	public List<PatientDTO> fetchPatientsByService(@PathVariable int id) {
		return psi.fetchPatientsByService(id);
	}

	@GetMapping("suivipatient/{id}")
	public List<CommentaryDTO> getCommentaryList(@PathVariable("id") long patient_id, Model model) {
		return psi.findCommentary(patient_id);
	}

}
