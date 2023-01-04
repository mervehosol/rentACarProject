package com.kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.rentACar.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {

	Brand findById(int id);
	Brand getByBrandName(String brandName);

    
}
