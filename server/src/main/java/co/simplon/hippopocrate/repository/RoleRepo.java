package co.simplon.hippopocrate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.hippopocrate.model.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

    Role findByName(String name);
}