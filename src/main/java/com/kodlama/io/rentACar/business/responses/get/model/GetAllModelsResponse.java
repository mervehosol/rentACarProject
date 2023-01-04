package com.kodlama.io.rentACar.business.responses.get.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	private int brandId;
	private int id;
	private String modelName;

}