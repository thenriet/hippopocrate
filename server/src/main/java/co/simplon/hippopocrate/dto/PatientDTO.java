package co.simplon.hippopocrate.dto;

import java.sql.Date;
import java.time.LocalDate;



public class PatientDTO {
	
	private long id; 
	private String firstname;
	private String lastname;
	private Date birthdate; 
	private String address;
	private LocalDate dateIn; 
	private LocalDate dateOut; 
	private long bedId;
	private long roomId;
	private long serviceId;
	private String serviceName;
	private long roomNumber;
	private long bedNumber;
	

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

	public LocalDate getDateIn() {
		return dateIn;
	}

	public void setDateIn(LocalDate dateIn) {
		this.dateIn = dateIn;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public long getBedId() {
		return bedId;
	}

	public void setBedId(long bedId) {
		this.bedId = bedId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getServiceId() {
		return serviceId;
	}

	public void setServiceId(long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public long getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(long roomNumber) {
		this.roomNumber = roomNumber;
	}

	public long getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(long bedNumber) {
		this.bedNumber = bedNumber;
	}

}