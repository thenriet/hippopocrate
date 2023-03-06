package co.simplon.hippopocrate.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Caroline
 * File that permit to transfer the commentary's informations
 *
 */
@jakarta.persistence.Entity
@Table(name = "records")

public class Commentary {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String comment;

	@JsonBackReference(value="patient-commentaries")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "patient_id", nullable = false)
	private Patient patient;

	@JsonBackReference(value="user-commentaries")
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public Commentary() {
	}

	public Commentary(long id, String commentary) {
		super();
		this.id = id;
		this.comment = commentary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentary() {
		return comment;
	}

	public void setCommentary(String commentary) {
		this.comment = commentary;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}