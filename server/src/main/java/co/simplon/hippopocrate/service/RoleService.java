package co.simplon.hippopocrate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Role;

/**
* @author Caroline
* Interface that contains the methods use for the role'
*
*/
@Service
public interface RoleService {
    Role findByName(String name);
    List<Role> findAll();
	Optional<Role> findById(int id);
}
