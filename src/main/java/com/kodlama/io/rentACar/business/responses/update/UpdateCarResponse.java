package com.kodlama.io.rentACar.business.responses.update;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarResponse {
	private int id;
	private String plate;
	private double price;
	private int state;
	private LocalDate leaseDate;
	private int modelId;
}
