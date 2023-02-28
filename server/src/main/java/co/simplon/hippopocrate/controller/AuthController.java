package co.simplon.hippopocrate.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.dto.PatientDTO;
import co.simplon.hippopocrate.model.Role;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.model.UserDto;
import co.simplon.hippopocrate.service.RoleService;
import co.simplon.hippopocrate.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class AuthController {
	
//	@Autowired
//	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
//	 Méthode page login qui teste le name et le password
	@PostMapping("login")
	public boolean login(@RequestBody User user) {
		User existingUser = userService.findUserByName(user.getName());
		if (existingUser != null) {
			return true;
		}
		return false;
//			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));
//			SecurityContextHolder.getContext().setAuthentication(authentication);
//			return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
	}
	
//	 Méthode pour récupérer la liste de Users
//	@GetMapping("users")
//	public List<User> getUsers() {
//		return this.userService.findAllUsers();
//	}
	
	//Méthode pour récupérer la liste des Users avec leur roles
	@GetMapping("usersDto")
	public List <UserDto> getUsersDto() {
		return this.userService.findAllUserDto();
	}
	
	@GetMapping("users/role/{name}")
	public String findRoleByName(@PathVariable String name) {
		return this.userService.findUserRoleDtoByName(name);
	}
	
	//Méthode pour récupérer tous les rôles existants
	@GetMapping("users/roles")
	public List<Role> getRoles() {
		return this.roleService.findAll();
	}
	
	@GetMapping("users/roles/{id}")
	public Optional<Role> getRoleById(@PathVariable int id) {
		return this.roleService.findById(id);
	}
	
    @PostMapping("users")
    void addUser(@RequestBody UserDto userDTO) {
    	this.userService.saveUser(userDTO);
    }
}