package co.simplon.hippopocrate.model;

/**
 * @author Caroline
 * File based on the User Model that permit to get the informations associate to an user 
 *
 */
public class UserDto {
	private long id;
	private String name;
	private String role;
	private String password;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
