package co.simplon.hippopocrate.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Caroline
 * File that permit to transfer the service' informations
 *
 */
@jakarta.persistence.Entity
@Table(name = "services")

public class ServiceHippo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@JsonBackReference(value="service-room")
	@OneToMany(mappedBy = "serviceHippo", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Set<Room> rooms;
	
	public ServiceHippo() {
		
	}
	
	public ServiceHippo(String name) {
		super();
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

}
