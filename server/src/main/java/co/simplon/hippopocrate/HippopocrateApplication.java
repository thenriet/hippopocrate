package co.simplon.hippopocrate;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.simplon.hippopocrate.controller.PatientController;
import co.simplon.hippopocrate.model.Patient;
import co.simplon.hippopocrate.service.PatientServiceImpl;

@SpringBootApplication
public class HippopocrateApplication implements CommandLineRunner {
	
	@Autowired
	private PatientServiceImpl psi;
	
	@Autowired
	private PatientController pc;

	public static void main(String[] args) {
		SpringApplication.run(HippopocrateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String strDate = "1993-09-14";
		Date date = Date.valueOf((String) strDate);
		Patient patient = new Patient("Amine", "Bouhaouche", date, 1, "Rue de la résistance");
		Patient patient1 = new Patient("Ondine", "Debienne", date, 1, "Rue de la résistance");
		System.out.println(psi.fetchPatientList());
//		psi.fetchPatientList().toString();
//		psi.updatePatient(patient1, 2);

		
//		psi.savePatient(patient);
//		pc.fetchPatientList();
	}

}
