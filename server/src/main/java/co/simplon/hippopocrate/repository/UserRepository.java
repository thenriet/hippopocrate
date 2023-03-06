package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.User;

/**
 * @author tom
 *
 * Repository containing CRUD methods for User
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}