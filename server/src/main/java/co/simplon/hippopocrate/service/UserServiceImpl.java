package co.simplon.hippopocrate.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Role;
import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.repository.RoleRepo;
import co.simplon.hippopocrate.repository.UserRepo;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	private UserRepo userRepository;
	private RoleRepo roleRepository;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepo userRepository, RoleRepo roleRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public List<User> findAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

//    @Override
//    public void saveUser(UserDto userDto) {
//        User user = new User();
//        user.setName(userDto.getName());
////        user.setEmail(userDto.getEmail());
//        // encrypt the password using spring security
//        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
//
//        Role role = roleRepository.findByName("ROLE_USER");
//        if(role == null){
//            role = checkRoleExist();
//        }
//        user.setRoles(Arrays.asList(role));
//        userRepository.save(user);
//    }

	@Override
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}

//    private UserDto mapToUserDto(User user){
//        UserDto userDto = new UserDto();
//        String str = user.getName();
//        userDto.setName(str);
////        userDto.setEmail(user.getEmail());
//        return userDto;
//    }

	private Role checkRoleExist() {
		Role role = new Role();
		role.setName("ROLE_USER");
		return roleRepository.save(role);
	}
}