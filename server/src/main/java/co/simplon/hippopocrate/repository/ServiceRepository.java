package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hippopocrate.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long> {

}
