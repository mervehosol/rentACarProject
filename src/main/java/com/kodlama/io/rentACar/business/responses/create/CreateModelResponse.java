package com.kodlama.io.rentACar.business.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelResponse {
	private int id;
	private int brandId;
	private String modelName;

}

