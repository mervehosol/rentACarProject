package com.kodlama.io.rentACar.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.rentACar.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

	Car findById(int id);
    Car getByPlate(String plate);

}
