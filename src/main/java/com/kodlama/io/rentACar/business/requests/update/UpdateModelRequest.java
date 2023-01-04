package com.kodlama.io.rentACar.business.requests.update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
	
	@NotNull
	private int brandId;
	@NotNull
	private int id;
	@NotEmpty
	@NotNull
	private String modelName;

}
