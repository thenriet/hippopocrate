package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import co.simplon.hippopocrate.model.Commentary;
import co.simplon.hippopocrate.model.Patient;

@Component
public interface CommentaryRepository extends JpaRepository<Commentary, Long>{
}