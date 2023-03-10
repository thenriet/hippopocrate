package co.simplon.hippopocrate.dto;

/**
 * @author Caroline
 * File based on the Commentary Model that permit to get the commentary informations associate to an User/patient 
 *
 */
public class CommentaryDTO {

	private long id;
	private String commentary;
	private String userName;
	private long userId;
	private long patientId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(Long id) {
		this.userId = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

}
