package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.repository.BedRepository;

/**
 * @author Caroline 
 * File that contained the methods used for the beds' management on our website
 *
 */
@Service
public class BedServiceImpl {
	
	@Autowired
    private BedRepository br;
	
	public Bed saveBed(Bed bed) {
		return br.save(bed);
	}
	
	public List<Bed> fetchBedList() {
		return br.findAll();
	}
	
	public Bed findBedById(long bedId) {
	
		return br.findById(bedId).get();
	}
	
	public Bed updateBed(Bed bed, long bedId) {
		Bed bedInDB = br.findById(bedId).get();
        return br.save(bedInDB);
    }

	public void deleteBedById(long bedId) {
		
	}

}
