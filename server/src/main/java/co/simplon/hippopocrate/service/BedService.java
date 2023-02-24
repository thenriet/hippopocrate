package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.model.Patient;

public interface BedService {
	
	 // save operation
    Bed saveBed(Bed bed);
  
    // read operation
    List<Bed> fetchBedList();
  
    // update operation
    Bed updateBed(Patient bed, long bedId);
  
    // delete operation
    void deleteBedById(long bedId);
}



