package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
 
//    @PostMapping("patients")
//    void addPatient(@RequestBody Patient patient) {
//    	psi.savePatient(patient);
//    }
    
    @PostMapping("patients")
    void addPatient(@RequestBody PatientDTO patientDTO) {
    	psi.savePatientDTO(patientDTO);
    }
    
    @GetMapping("patients/{id}")
    public Patient findById(@PathVariable long id) {
    	return psi.findPatientById(id);
    }
    

//	@PostMapping({"addpatient"})
//	public String savePatient(Model model, //
//			@ModelAttribute("patientForm") PatientForm patientAddForm) {
//
//		String firstname = patientAddForm.getFirstname();
//		String lastname = patientAddForm.getLastname();
//		String address = patientAddForm.getAddress();
//		Date birthdate = patientAddForm.getBirthdate();
//		int bed_id = patientAddForm.getBed_id();
//		ZoneId z = ZoneId.of( "Europe/France" );
//		LocalDate today = LocalDate.now( z );// Always pass a time zone.
//
//
//		if (firstname != null && firstname.length() > 0 //
//				&& lastname != null && lastname.length() > 0 //
//				&& address != null && address.length() > 0 //
//				&& birthdate != null //
//				&& bed_id > 0) {
//			Patient newPatient = new Patient(firstname, lastname, birthdate, bed_id, address,today, null);
//			psi.savePatient(newPatient);
//
//			return "redirect:/patients";
//		}
//
////		model.addAttribute("errorMessage", errorMessage);
//		return "addpatient";
//	}
	
//	@GetMapping("edit/{id}")
//	public String showUpdateForm(@PathVariable("id") long id, Model model) {
//	    Patient patient = psi.findPatientById(id);
//	    model.addAttribute("patient", patient);
//	    PatientForm patientEditform = new PatientForm();
//	    String firstname = patient.getFirstname();
//	    patientEditform.setFirstname(firstname);
//	    return "edit/{id}";
//	}
//	
//	@PostMapping("/update/{id}")
//	public String updatePatient(Patient patient, @PathVariable("id") int id,
//	  BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	        patient.setId(id);
//	        return "updatePatient";
//	    }
//	   
//	    psi.updatePatient(patient, id);
//	    return "redirect:/patients";
//	}

}
