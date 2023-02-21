package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.service.PatientServiceImpl;


@Controller 
public class PatientController {
	
	@Autowired
	private  PatientServiceImpl psi;
	
	public List<Patient> fetchPatientList() {
		return psi.fetchPatientList();
	}

}
