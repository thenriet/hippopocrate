package co.simplon.hippopocrate.model;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "services")

public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Date date_in;
	private Date date_out;
	
	public Service() {
		
	}
	
	public Service(int id, String name, Date date_in, Date date_out) {
		super();
		this.id = id;
		this.name = name;
		this.date_in = date_in;
		this.date_out = date_out;
	}

	public long getId() {
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

	public Date getDate_in() {
		return date_in;
	}

	public void setDate_in(Date date_in) {
		this.date_in = date_in;
	}

	public Date getDate_out() {
		return date_out;
	}

	public void setDate_out(Date date_out) {
		this.date_out = date_out;
	}
	
	

}
