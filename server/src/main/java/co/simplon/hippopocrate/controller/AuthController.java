package co.simplon.hippopocrate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("api/")
public class AuthController {

	@Autowired
	private UserService userService;

//	 Méthode page login qui teste le name et le password
	@RequestMapping("login")
	public boolean login(@RequestBody User user) {
		User existingUser = userService.findUserByName(user.getName());
		if (existingUser != null) {
			return true;
		}
		return false;
	}

//	 handler method to handle home page request
	@GetMapping("/index")
	public String home() {
		return "index";
	}

//	 Méthode pour récupérer la liste de Users
	@GetMapping("users")
	public List<User> getUsers() {
		return this.userService.findAllUsers();
	}
}