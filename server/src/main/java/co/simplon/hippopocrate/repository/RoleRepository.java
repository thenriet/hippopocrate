package co.simplon.hippopocrate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.Role;
import co.simplon.hippopocrate.model.User;

/**
 * @author tom
 * Repository containing CRUD methods for Role
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Role findByName(String name);
}