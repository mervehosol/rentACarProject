package com.kodlama.io.rentACar.webAbi;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.rentACar.business.abstracts.CarService;
import com.kodlama.io.rentACar.business.requests.create.CreateCarRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateCarRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateCarResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetAllCarsResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetCarResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateCarResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/cars")
@RestController
@AllArgsConstructor
public class CarsController {
	private CarService carService;
	
	   @GetMapping()
	    public DataResult<List<GetAllCarsResponse>> getAll(){
	        return this.carService.getAll();
	    }
	   
	    @PostMapping()
	    public DataResult<CreateCarResponse> add(@Valid @RequestBody CreateCarRequest createCarRequest) {
	        return this.carService.add(createCarRequest);
	    }
	    @PutMapping()
	    public DataResult<UpdateCarResponse> update(@Valid @RequestBody UpdateCarRequest updateCarRequest){
	        return this.carService.update(updateCarRequest);
	    }
	    @DeleteMapping("/{id}")
	   public Result  delete(@PathVariable  int id){
	        return this.carService.delete(id);
	   }

	    @GetMapping("/{id}")
	    public DataResult<GetCarResponse> getById(@PathVariable int id){
	        return this.carService.getByCarId(id);
	    }
}
