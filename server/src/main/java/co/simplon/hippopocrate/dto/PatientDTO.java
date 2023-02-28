package co.simplon.hippopocrate.dto;

import java.sql.Date;
import java.time.LocalDate;



public class PatientDTO {
	
	private long id; 
	private String firstname;
	private String lastname;
	private Date birthdate; 
	private String address;
	private LocalDate date_in; 
	private LocalDate date_out; 
	private long bed_id;
	private long room_id;
	private long service_id;

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Long getBed_id() {
		return bed_id;
	}

	public void setBed_id(long bed_id) {
		this.bed_id = bed_id;
	}

	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public long getService_id() {
		return service_id;
	}

	public void setService_id(long service_id) {
		this.service_id = service_id;
	}

	@Override
	public String toString() {
		return "PatientDTO [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", birthdate=" + birthdate + ", address=" + address + ", date_in=" + date_in + ", date_out="
				+ date_out + ", bed_id=" + bed_id + ", room_id=" + room_id + ", service_id=" + service_id + "]";
	}

}
