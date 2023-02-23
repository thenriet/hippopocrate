package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.service.PatientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<Patient> findAllUser() {

		return this.patientService.findAllPatients();
	}

}
