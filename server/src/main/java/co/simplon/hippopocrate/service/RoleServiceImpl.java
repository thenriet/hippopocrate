package co.simplon.hippopocrate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.hippopocrate.model.Role;
import co.simplon.hippopocrate.repository.RoleRepository;

/**
 * @author Caroline 
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

	@Override
	public Role findByName(String name) {
		// TODO Auto-generated method stub
		return this.roleRepository.findByName(name);
	}
	
	@Override
	public Optional<Role> findById(int id) {
		// TODO Auto-generated method stub
		return this.roleRepository.findById(id);
	}

	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return this.roleRepository.findAll();
	}
}
