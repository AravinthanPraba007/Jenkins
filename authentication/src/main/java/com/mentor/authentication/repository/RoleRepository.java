package com.mentor.authentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mentor.authentication.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

	Role findByName(String user);
}
