package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
