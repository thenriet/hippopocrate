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
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Method to fetch all the rooms
	 *
	 */
	@Override
	public List<Room> fetchRoomList() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRoomById(long roomId) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Method to find a room by its id
	 * @param roomId
	 * @return the room object
	 *
	 */
	@Override
	public Room findById(long roomId) {
		return this.Rr.findById(roomId).get();
	}

}
