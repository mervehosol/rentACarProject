package com.kodlama.io.rentACar.business.requests.update;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
	@NotNull
	private int id;
	@NotNull
	@NotEmpty
	private String plate;
	@NotNull
	private double price;
	@NotNull
	private int state;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate leaseDate;
	@NotNull
	private int modelId;
}
