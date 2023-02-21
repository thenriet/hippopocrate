package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hippopocrate.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
