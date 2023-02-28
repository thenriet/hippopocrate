package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Patient;

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
