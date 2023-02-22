package co.simplon.hippopocrate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HippopocrateApplication implements CommandLineRunner {
	
	@Autowired
	private PatientServiceImpl psi;
	
	@Autowired
	private PatientController pc;


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		String strDate = "1993-09-14";
//		Date date = Date.valueOf((String) strDate);
//		Patient patient = new Patient("Amine", "Bouhaouche", date, 1, "Rue de la résistance");
//		Patient patient1 = new Patient("Ondine", "Debienne", date, 1, "Rue de la résistance");
//		System.out.println(psi.fetchPatientList());
//		psi.fetchPatientList().toString();
//		psi.updatePatient(patient1, 2);

		
//		psi.savePatient(patient);
//		pc.fetchPatientList();
	}

}
