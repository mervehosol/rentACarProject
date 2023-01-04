package com.kodlama.io.rentACar.business.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CreateModelRequest {
	
	
	private int brandId;
	private String modelName;
	
}
