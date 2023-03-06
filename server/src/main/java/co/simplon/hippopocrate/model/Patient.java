package co.simplon.hippopocrate.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * @author Caroline
 * File that permit to transfer the patient's informations
 *
 */
@jakarta.persistence.Entity
@Table(name = "patients")

public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String firstname;
	@Column(nullable = false)
	private String lastname;
	@Column(nullable = false)
	private Date birthdate;
	@Column(nullable = false)
	private String address;
	private LocalDate dateIn;
	private LocalDate dateOut;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonBackReference(value = "patient-bed")
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "bed_id", referencedColumnName = "id", nullable = true)
	private Bed bed;

	@JsonBackReference(value = "patient_commentary")
	@OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Commentary> commentaries;

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

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public List<Commentary> getCommentaries() {
		return commentaries;
	}

	public void setCommentaries(List<Commentary> commentaries) {
		this.commentaries = commentaries;
	}

}