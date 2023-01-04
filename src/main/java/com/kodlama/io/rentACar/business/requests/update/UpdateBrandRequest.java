package com.kodlama.io.rentACar.business.requests.update;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBrandRequest {
	@NotNull
	private int id;
	@NotEmpty
	@NotNull
	private String brandName;

}
