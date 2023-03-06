
package co.simplon.hippopocrate.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Role;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.model.UserDto;
import co.simplon.hippopocrate.service.RoleService;
import co.simplon.hippopocrate.service.UserService;

/**
 * @author Caroline
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	/**
	 * Method that permit to test the name and the password on the login page
	 * @param user
	 * @return The associated user
	 */
	@PostMapping("login")
	public boolean login(@RequestBody User user) {
		User existingUser = userService.findUserByName(user.getName());
		return (existingUser != null);
}
	
	/**
	 * Method used to get the list of Users
	 * @return the Users's list 
	 */	
	@GetMapping("usersDto")
	public List <UserDto> getUsersDto() {
		return this.userService.findAllUserDto();
	}
	
	/**
	 * Method to get the User's role thanks to his/her name
	 * @return the user's role
	 */	
	@GetMapping("users/role/{name}")
	public String findRoleByName(@PathVariable String name) {
		return this.userService.findUserRoleDtoByName(name);
	}
	
	/**
	 * Method to find a User's role thanks to his/her id
	 * @param id
	 * @return the appropriate User's role
	 */
	@GetMapping("users/roles/{id}")
	public Optional<Role> getRoleById(@PathVariable int id) {
		return this.roleService.findById(id);
	}
	
	@GetMapping("users/roles")
	public List<Role> getAllROles() {
		return this.roleService.findAll();
	}
	/**
	 * Method to save a user in the database
	 * @param userDTO
	 */
    @PostMapping("users")
    void addUser(@RequestBody UserDto userDTO) {
    	this.userService.saveUser(userDTO);
    }
    
	/**
	 * Method to find a user thank to his id 
	 * @param id
	 * @return the User
	 */
	@GetMapping("users/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return this.userService.findById(id);
	}
	
	/**
	 * Method to find a User thank to his/her name
	 * @param name
	 * @return the User
	 */
	@GetMapping("users/id/{username}")
	public long getUserIdByName(@PathVariable String username) {
		return this.userService.findByName(username);
	}
	
	/**
	 * Method to modify an existing User's role
	 * @param userDTO 
	 * @return the new User's role
	 */
	@PutMapping("updateuser/{id}")
	void updateUser (@RequestBody UserDto userDTO, @PathVariable long id) {
		this.userService.updateUser(userDTO, id);
	}
}