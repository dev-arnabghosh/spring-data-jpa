package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Model;

public interface ModelRespository extends JpaRepository<Model, Integer> {

}
