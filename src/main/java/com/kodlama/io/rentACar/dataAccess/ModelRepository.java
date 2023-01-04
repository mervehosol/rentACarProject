package com.kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.rentACar.entities.Model;

public interface ModelRepository extends JpaRepository<Model, Integer>{
	Model findById(int modelId);
	Model getByModelName(String modelName);


}
