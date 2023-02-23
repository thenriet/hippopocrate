package co.simplon.hippopocrate.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.Role;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.service.UserService;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/")
public class AuthController {

	@Autowired
	private UserService userService;
	
//	 Méthode page login qui teste le name et le password
	@RequestMapping("login")
	public boolean login(@RequestBody User user) {
		User existingUser = userService.findUserByName(user.getName());
		if(existingUser != null) {
			return true;
		}
		return false;
	}

//	 Méthode pour récupérer la liste de Users
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userService.findAllUsers();
	}
}