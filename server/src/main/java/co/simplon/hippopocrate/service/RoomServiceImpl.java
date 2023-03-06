package co.simplon.hippopocrate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Room;
import co.simplon.hippopocrate.repository.RoomRepository;

/**
 * @author Caroline 
 * File that contained the methods used for the rooms' management on our website
 *
 */
@Service
public class RoomServiceImpl implements RoomService {
	
	@Autowired
	private RoomRepository Rr;
	
	/**
	 * Method to save a room
	 * @param room
	 *
	 */
	@Override
	public Room saveRoom(Room room) {
		return null;
	}

	/**
	 * Method to fetch all the rooms
	 *
	 */
	@Override
	public List<Room> fetchRoomList() {
		return null;
	}

	/**
	 * Method to update a room
	 * @param room
	 * @param roomId
	 *
	 */
	@Override
	public Room updateRoom(Room room, long roomId) {
		return null;
	}

	@Override
	public void deleteRoomById(long roomId) {
		// Method that we do not use but is mandatory
		
	}
	
	/**
	 * Method to find a room by its id
	 * @param roomId
	 * @return the room object
	 *
	 */
	@Override
	public Room findById(long roomId) {
		Room room = new Room();
		if(this.Rr.findById(roomId).isPresent()) {
			room = this.Rr.findById(roomId).get();
		}
		return room;
	}

}
