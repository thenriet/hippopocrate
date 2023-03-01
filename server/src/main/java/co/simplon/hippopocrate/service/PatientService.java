package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;

public interface PatientService {
    // save operation
    Patient savePatient(Patient patient);
  
    // read operation
    List<Patient> fetchPatientList();
  
    // update operation
    Patient updatePatient(Patient patient, int id);
  
    // delete operation
    void deletePatientById(int id);

//	Commentary saveCommentary(Commentary commentary);    
    

}
