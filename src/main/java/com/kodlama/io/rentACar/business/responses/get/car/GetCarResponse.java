package com.kodlama.io.rentACar.business.responses.get.car;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCarResponse {
	private int id;
	private String plate;
	private double price;
	private int state;
	private LocalDate leaseDate;
	private int modelId;
}
