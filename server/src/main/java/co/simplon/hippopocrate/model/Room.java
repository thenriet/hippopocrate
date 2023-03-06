package co.simplon.hippopocrate.model;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Caroline
 * File that permit to transfer the rooms' informations
 *
 */
@jakarta.persistence.Entity
@Table(name = "rooms")

public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int number;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceHippo serviceHippo;
	
	@JsonBackReference(value="room-bed")
	@OneToMany(mappedBy = "room", fetch = FetchType.EAGER,
	            cascade = CascadeType.ALL)
	private Set<Bed> beds;
	
	public Room() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ServiceHippo getService() {
		return serviceHippo;
	}

	public void setService(ServiceHippo serviceHippo) {
		this.serviceHippo = serviceHippo;
	}

	public Set<Bed> getBeds() {
		return beds;
	}

	public void setBeds(Set<Bed> beds) {
		this.beds = beds;
	}

}
