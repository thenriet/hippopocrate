package co.simplon.hippopocrate.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Bed;
import co.simplon.hippopocrate.model.Room;
import co.simplon.hippopocrate.model.ServiceHippo;
import co.simplon.hippopocrate.repository.RoomRepository;
import co.simplon.hippopocrate.repository.ServiceRepository;

@Service
public class ServiceServImpl implements ServiceServ {
		
	@Autowired
    private ServiceRepository sr;

	@Autowired
	private RoomRepository rr;
	
	
	public List<ServiceHippo> fetchServiceList() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}
	
	public ServiceHippo findServiceById(long serviceId) {
		return sr.findById(serviceId).get();
	}
	
	public Set<Room> findRooms(long serviceId) {
		sr.findById(serviceId).get().getRooms();
		Set<Room> rooms = sr.findById(serviceId).get().getRooms();
		Set<Room> sortedRooms = new HashSet<Room>();
		rooms.forEach((room) -> {
		      if(!this.findBeds(room.getId()).isEmpty()) {
		    	  sortedRooms.add(room);
		      };
		    });
		return sortedRooms;
	}
		
	
	public Set<Bed> findBeds(long roomId) {
		 Set<Bed> beds = rr.findById(roomId).get().getBeds();
		 Set<Bed> sortedBeds = new HashSet<Bed>();
		 beds.forEach((bed) -> {
		      if(bed.isOccupied() == false) {
		    	  sortedBeds.add(bed);
		      };
		    });
		return sortedBeds;
	}

}
