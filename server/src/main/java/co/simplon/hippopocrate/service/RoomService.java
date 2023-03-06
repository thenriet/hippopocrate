package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.Room;

public interface RoomService {
	
	// save operation
    Room saveRoom(Room room);
  
    // read operation
    List<Room> fetchRoomList();
  
    // update operation
    Room updateRoom(Room room, long roomId);
  
    // delete operation
    void deleteRoomById(long roomId);
    
    //find by Id
    Room findById(long roomId);

}
