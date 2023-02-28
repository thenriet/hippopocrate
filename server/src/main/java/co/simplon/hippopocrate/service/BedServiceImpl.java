package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.repository.BedRepository;

@Service
public class BedServiceImpl {
	
	@Autowired
    private BedRepository br;
	
	public Bed saveBed(Bed bed) {
		// TODO Auto-generated method stub
		return br.save(bed);
	}
	
	public List<Bed> fetchBedList() {
		// TODO Auto-generated method stub
		return br.findAll();
	}
	
	public Bed findBedById(long bedId) {
		return br.findById(bedId).get();
	}
	
	public Bed updateBed(Bed bed, long bedId) {
		// TODO Auto-generated method stub
		Bed bedInDB = br.findById(bedId).get();
		
  
        return br.save(bedInDB);
    }

	public void deleteBedById(long bedId) {
		// TODO Auto-generated method stub
		
	}

}
