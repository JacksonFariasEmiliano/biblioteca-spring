package com.br.jalves.biblioteca.repository;

import com.br.jalves.biblioteca.models.ERole;
import com.br.jalves.biblioteca.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
