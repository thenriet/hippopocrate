package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.repository.BedRepository;

/**
 * @author Caroline , Ondine
 * File that contained the methods used for the beds' management on our website
 *
 */
@Service
public class BedServiceImpl {
	
	@Autowired
    private BedRepository br;
	
	/**
	 * Method to save a new bed
	 * @param bed
	 * @return
	 */
	public Bed saveBed(Bed bed) {
		return br.save(bed);
	}
	
	/**
	 * Method to fetch all the beds
	 * @return the list of beds
	 */
	public List<Bed> fetchBedList() {
		return br.findAll();
	}
	
	/**
	 * Method to find a bed by its id
	 * @param bedId
	 * @return the bed object
	 */
	public Bed findBedById(long bedId) {
		Bed bed =  new Bed();
		if(br.findById(bedId).isPresent()) {
			bed = br.findById(bedId).get();
		}
		return bed;
	}
	
	/**
	 * Method to update a bed by its id
	 * @param bed the bed object
	 * @param bedId
	 * @return
	 */
	public Bed updateBed(Bed bed, long bedId) {
		Bed bedInDB = new Bed();
		if(br.findById(bedId).isPresent()) {
			bedInDB = br.findById(bedId).get();
		}
        return br.save(bedInDB);
    }

	public void deleteBedById(long bedId) {
   // Method is empty because we do not use it but it is mandatory
 }

}
