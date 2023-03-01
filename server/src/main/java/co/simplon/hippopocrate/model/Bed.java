package co.simplon.hippopocrate.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "beds")
public class Bed {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int number;
	private boolean occupied;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;
	
	@JsonBackReference(value="bed-patient")
	@OneToOne(mappedBy = "bed", cascade=CascadeType.ALL)
	@JoinColumn(nullable=true)
    private Patient patient;
	
	public Bed() {
		
	}
	
	public Bed(int number, int room_id, boolean occupied) {
		super();
		this.number = number;
		this.occupied = occupied;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public void toggleOccupied() {
		this.occupied = !occupied;
	}
}

