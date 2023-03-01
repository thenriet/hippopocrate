package co.simplon.hippopocrate.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.*;
import co.simplon.hippopocrate.service.PatientServiceImpl;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class PatientController {

	@Autowired
	private PatientServiceImpl psi;

	@GetMapping("patients")
	public List<Patient> fetchPatientList() {
		return psi.fetchPatientList();
	}

	@PostMapping("patients")
	void addPatient(@RequestBody Patient patient) {
//		ZoneId z = ZoneId.of("Europe/France");
//		LocalDate today = LocalDate.now(z);// Always pass a time zone.
		psi.savePatient(patient);
	}
	
	@GetMapping("patients/{id}")
	public Patient findById(@PathVariable int id) {
		return psi.findPatientById(id);
	}
	
	@GetMapping("updatepatient/{id}")
	public Patient updateById(@PathVariable int id) {
		return psi.findPatientById(id);
	}
	
	@PutMapping("updatepatient/{id}")
	void updatePatient(@RequestBody Patient patient, @PathVariable int id) {
		System.out.println("je suis là!");
		psi.updatePatient(patient, id);
	}
	
}
