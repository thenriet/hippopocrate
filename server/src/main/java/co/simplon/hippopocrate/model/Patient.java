package co.simplon.hippopocrate.model;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "patients")

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private Date birthdate;
	private int bed_id;
	private String address;
	private LocalDate date_in;
	private LocalDate date_out;
	
	public Patient() {
		
	}
	
	public Patient(String firstname, String lastname, Date birthdate, int bed_id, String address,  LocalDate date_in,  LocalDate date_out) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.bed_id = bed_id;
		this.address = address;
		this.date_in = date_in;
		this.date_out = date_out;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", bed_id=" + bed_id + ", address=" + address + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public int getBed_id() {
		return bed_id;
	}

	public void setBed_id(int bed_id) {
		this.bed_id = bed_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDate_in() {
		return date_in;
	}

	public void setDate_in(LocalDate date_in) {
		this.date_in = date_in;
	}

	public LocalDate getDate_out() {
		return date_out;
	}

	public void setDate_out(LocalDate date_out) {
		this.date_out = date_out;
	}
	
	

}