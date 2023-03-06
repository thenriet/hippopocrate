package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import co.simplon.hippopocrate.model.Commentary;


/**
 * @author Caroline
 *
 * Repository containing CRUD methods for commentary
 */
 
@Component
public interface CommentaryRepository extends JpaRepository<Commentary, Long> {
}