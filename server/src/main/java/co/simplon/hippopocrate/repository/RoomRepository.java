package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import co.simplon.hippopocrate.model.Room;

@Component 
public interface RoomRepository extends JpaRepository<Room, Long> {

}
