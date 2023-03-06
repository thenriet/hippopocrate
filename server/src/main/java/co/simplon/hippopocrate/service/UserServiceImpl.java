package co.simplon.hippopocrate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Role;
import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.model.UserDto;
import co.simplon.hippopocrate.repository.RoleRepository;
import co.simplon.hippopocrate.repository.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Caroline, Ondine
 * File that contained the methods used for the Users' management on our website
 *
 */
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleService roleService;

	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Method to save a new user in the database from a userDTo object
	 * @param userDto
	 *
	 */
	@Override
	public void saveUser(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getName());
		// encrypt the password using spring security
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Role role = roleService.findByName(userDto.getRole());
		user.setRoles(Arrays.asList(role));
		userRepository.save(user);
	}

	/**
	 *Method to fetch all the existing users
	 *@return the list of users
	 */
	@Override
	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	/**
	 * Method to find all the existing users and convert them into userDTO objects
	 * @return the list of userDTO objects
	 *
	 */
	@Override
	public List<UserDto> findAllUserDto() {
		List<UserDto> usersDto = new ArrayList();
		List<User> users = userRepository.findAll();
		for (User user : users) {
			UserDto userDto = new UserDto();
			List<Role> roles = user.getRoles();
			for (Role role : roles) {
				String roleString = role.getName();
				userDto.setRole(roleString);
			}
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			usersDto.add(userDto);
		}
		return usersDto;
	}

	/**
	 * Method to update a user in the database from a userDTO object
	 * @param userDTO
	 * @param id the user id
	 *
	 */
	@Override
	public void updateUser(UserDto userDTO, long id) {
		User user = this.userRepository.findById(id).get();
		System.out.println(userDTO);
		if(userDTO.getName() == null) {
			user.setName(userDTO.getName());
		} else {
			user.setName(userDTO.getName());
		}
		user.setPassword(userDTO.getPassword());
		Role role = roleService.findByName(userDTO.getRole());
		System.out.println(user.getRoles());
		if (user.getRoles().size() == 0) {
			ArrayList<Role> roles = new ArrayList<>(user.getRoles());
			roles.add(role);
			user.setRoles(roles);
		} else {
			user.getRoles().set(0, role);
		}

		userRepository.save(user);
	}

	/**
	 * Method to find the role of a user thanks to the user name
	 * @param name the name of the user
	 * @return the role of the user
	 *
	 */
	@Override
	public String findUserRoleDtoByName(String name) {
		User user = userRepository.findByName(name);
		UserDto userDto = new UserDto();
		List<Role> roles = user.getRoles();
		for (Role role : roles) {
			String roleString = role.getName();
			userDto.setRole(roleString);
		}
		return userDto.getRole();

	}
	
	/**
	 * Method to find a user by his name
	 * @param name
	 * @return the user
	 *
	 */
	@Override
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}

	/**
	 * Method to find a user by his id
	 * @param id
	 * @return the user
	 *
	 */
	@Override
	public Optional<User> findById(long id) {
		return userRepository.findById(id);
	}

	/**
	 * Method to find a user id by the user name
	 * @param name
	 * @return the user id
	 *
	 */
	@Override
	public long findByName(String username) {
		User user = userRepository.findByName(username);
		return user.getId();
	}

}