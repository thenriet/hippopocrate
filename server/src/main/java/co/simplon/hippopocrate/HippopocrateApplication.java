package co.simplon.hippopocrate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.simplon.hippopocrate.service.PatientServiceImpl;

@SpringBootApplication
public class HippopocrateApplication implements CommandLineRunner {
	
	@Autowired
	private PatientServiceImpl psi;
	
	public static void main(String[] args) {
		SpringApplication.run(HippopocrateApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(psi.createPatientDTOFromDB(1));
		System.out.println(psi.createPatientsDTOFromDB());
		
	}

}
