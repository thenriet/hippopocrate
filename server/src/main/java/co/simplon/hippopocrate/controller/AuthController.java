package co.simplon.hippopocrate.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.model.UserDto;
import co.simplon.hippopocrate.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class AuthController {
	
//	@Autowired
//	AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;
	
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
	
//	@RequestMapping("register")
//	public boolean register()

//	 Méthode pour récupérer la liste de Users
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userService.findAllUsers();
	}
	
	@GetMapping("users/roles")
	public List <UserDto> getRoles() {
		return this.userService.findAllUserDto();
	}
	
	@GetMapping("users/roles/{name}")
	public String findRoleByName(@PathVariable String name) {
		return this.userService.findUserRoleDtoByName(name);
	}
}