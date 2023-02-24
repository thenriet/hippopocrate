package co.simplon.hippopocrate.model;

import java.sql.Date;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "patients")

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String firstname;
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false)
	private Date birthdate;
	@Column(nullable=false)
	private String address;
	private LocalDate date_in;
	private LocalDate date_out;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonBackReference(value="patient-bed")
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bed_id", referencedColumnName = "id")
    private Bed bed;
	
	public Patient() {
		
	}
	
	public Patient(String firstname, String lastname, Date birthdate, int bed_id, String address,  LocalDate date_in,  LocalDate date_out) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.address = address;
		this.date_in = date_in;
		this.date_out = date_out;
	}
	
	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", birthdate=" + birthdate
				+ ", bed_id=" + ", address=" + address + "]";
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

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

}
