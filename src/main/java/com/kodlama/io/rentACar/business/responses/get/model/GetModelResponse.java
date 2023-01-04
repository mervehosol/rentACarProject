package com.kodlama.io.rentACar.business.responses.get.model;

import java.util.List;

import com.kodlama.io.rentACar.entities.Car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetModelResponse {
	private int brandId;
	private int id;
	private String modelName;
	private List<Car> cars;
}
