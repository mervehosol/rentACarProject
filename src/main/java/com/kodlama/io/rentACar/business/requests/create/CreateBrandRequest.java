package com.kodlama.io.rentACar.business.requests.create;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class CreateBrandRequest {
	@NotNull
	@NotEmpty
    private String brandName;

	
}
