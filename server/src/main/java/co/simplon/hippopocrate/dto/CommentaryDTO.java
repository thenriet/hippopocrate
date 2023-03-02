package co.simplon.hippopocrate.dto;

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
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	

}
