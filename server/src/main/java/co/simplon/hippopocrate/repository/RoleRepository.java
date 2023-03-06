package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.Role;

/**
 * @author tom
 * Repository containing CRUD methods for Role
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	 Role findByName(String name);
}