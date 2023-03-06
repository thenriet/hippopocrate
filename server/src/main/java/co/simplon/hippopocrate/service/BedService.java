package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.Bed;

/**
 * @author Caroline
 * Interface that contains the methods use for the beds'
 *
 */
public interface BedService {
	
	 // save operation
    Bed saveBed(Bed bed);
  
    // read operation
    List<Bed> fetchBedList();
  
    // update operation
    Bed updateBed(Bed bed, long bedId);
  
    // delete operation
    void deleteBedById(long bedId);
}



