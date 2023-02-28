package co.simplon.hippopocrate.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name ="records")

public class Commentary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String[] commentary;
	private int patient_id;
	private int user_id; 
	
	public Commentary () {
		
	}

	public Commentary(int id, String[] commentary, int patient_id, int user_id) {
		super();
		this.id = id;
		this.commentary = commentary;
		this.patient_id = patient_id;
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String[] getCommentary() {
		return commentary;
	}

	public void setCommentary(String[] commentary) {
		this.commentary = commentary;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}
