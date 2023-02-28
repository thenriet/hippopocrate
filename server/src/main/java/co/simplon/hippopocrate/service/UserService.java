package co.simplon.hippopocrate.service;

import java.util.List;

import co.simplon.hippopocrate.model.User;
import co.simplon.hippopocrate.model.UserDto;

public interface UserService {

    User findUserByName(String name);

    List<User> findAllUsers();
    
    List<UserDto> findAllUserDto();

	String findUserRoleDtoByName(String name);

	void saveUser(UserDto userDto);
}
