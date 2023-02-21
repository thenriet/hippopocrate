package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.service.PatientServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
@RestController
@RequestMapping("api/")
public class PatientController {
	
	@Autowired
	private  PatientServiceImpl psi;
	
    @GetMapping("patients")
	public List<Patient> fetchPatientList() {
		return psi.fetchPatientList();
	}

}
