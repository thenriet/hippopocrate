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

/**
 * @author Caroline, Ondine File that contained the methods used for the
 *         services' management on our website
 *
 */
@Service
public class ServiceServImpl implements ServiceServ {

	@Autowired
	private ServiceRepository sr;

	@Autowired
	private RoomRepository rr;

	/**
	 * Method to fetch all the services
	 * 
	 * @return the list of services
	 *
	 */
	public List<ServiceHippo> fetchServiceList() {
		return sr.findAll();
	}

	/**
	 * Method to find a service by its id
	 * 
	 * @param serviceId
	 * @return the service object
	 */
	public ServiceHippo findServiceById(long serviceId) {
		ServiceHippo serviceHippo = new ServiceHippo();
		if(sr.findById(serviceId).isPresent()) {
			serviceHippo = sr.findById(serviceId).get();
		}
		return serviceHippo;
	}

	/**
	 * Method to find all the rooms with empty beds of a specific service
	 * 
	 * @param serviceId
	 * @return the list of rooms
	 */
	public Set<Room> findRooms(long serviceId) {
		Set<Room> rooms = new HashSet<>();
		if (sr.findById(serviceId).isPresent()) {
			rooms = sr.findById(serviceId).get().getRooms();
		}
		Set<Room> sortedRooms = new HashSet<>();
		rooms.forEach(room -> {
			if (!this.findBeds(room.getId()).isEmpty()) {
				sortedRooms.add(room);
			}
		});
		return sortedRooms;
	}

	/**
	 * Method to find all the unoccupied beds from a specific room by its id
	 * 
	 * @param roomId
	 * @return the list of beds
	 */
	public Set<Bed> findBeds(long roomId) {
		Set<Bed> beds = new HashSet<>();
		if (rr.findById(roomId).isPresent()) {
			beds = rr.findById(roomId).get().getBeds();
		}
		Set<Bed> sortedBeds = new HashSet<>();
		beds.forEach(bed -> {
			if (!bed.isOccupied()) {
				sortedBeds.add(bed);
			}
		});
		return sortedBeds;
	}

}
