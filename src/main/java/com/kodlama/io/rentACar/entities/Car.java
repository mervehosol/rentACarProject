package com.kodlama.io.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class Car {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "plate")
	private String plate;
	@Column(name = "price")
	private double price;
	@Column(name = "state")
	private int state;
	@Column(name = "leaseDate")
	private LocalDate leaseDate;

	
	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;

}
