package org.example.todospring.repository;

import org.example.todospring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRole(String roleName);
}
