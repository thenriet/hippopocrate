package co.simplon.hippopocrate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Role;
import co.simplon.hippopocrate.repository.RoleRepository;

/**
 * @author Caroline, Ondine 
 * File that contained the methods used for the roles' management on our website
 *
 */
@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	public RoleServiceImpl(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	/**
	 * Method to find a role by its name
	 * @param name the role name
	 * @return the role object
	 *
	 */
	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return this.roleRepository.findByName(name);
	}
	
	/**
	 * Method to find a role by its id
	 * @param id
	 * @return the role object
	 *
	 */
	@Override
	public Optional<Role> findById(int id) {
		// TODO Auto-generated method stub
		return this.roleRepository.findById(id);
	}

	/**
	 * Method to find all the roles
	 * return the list of roles
	 *
	 */
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return this.roleRepository.findAll();
	}
}
