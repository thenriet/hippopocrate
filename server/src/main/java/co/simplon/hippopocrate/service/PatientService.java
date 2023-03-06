package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Patient;

/**
* @author Caroline
* Interface that contains the methods use for the patients'
*
*/
public interface PatientService {
    // save operation
    Patient savePatient(Patient patient);
  
    // read operation
    List<Patient> fetchPatientList();
  
    // update operation
    Patient updatePatient(PatientDTO patientDTO, long patientId);
  
    // delete operation
    void deletePatientById(long patientId);
}