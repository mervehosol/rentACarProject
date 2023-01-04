package com.kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.rentACar.business.abstracts.CarService;
import com.kodlama.io.rentACar.business.constants.Messages;
import com.kodlama.io.rentACar.business.requests.create.CreateCarRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateCarRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateCarResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetAllCarsResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetCarResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateCarResponse;
import com.kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import com.kodlama.io.rentACar.core.utilities.maping.ModelMapperService;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;
import com.kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import com.kodlama.io.rentACar.core.utilities.results.SuccessResult;
import com.kodlama.io.rentACar.dataAccess.CarRepository;
import com.kodlama.io.rentACar.entities.Car;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CarManager implements CarService{
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllCarsResponse>> getAll() {
		List<Car> cars= this.carRepository.findAll();
		List<GetAllCarsResponse> allCarsResponses= cars.stream()
				.map(car ->this.modelMapperService.forResponse().map(car, GetAllCarsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllCarsResponse>>(allCarsResponses,Messages.CarListed);
	}

	@Override
	public DataResult<CreateCarResponse> add(CreateCarRequest createCarRequest) {
		checkIfCarPlateExist(createCarRequest.getPlate());
		Car car =this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);
		CreateCarResponse createCarResponse =this.modelMapperService.forResponse()
				.map(car, CreateCarResponse.class);
		return new SuccessDataResult<CreateCarResponse>(createCarResponse,Messages.CarCreated);
	}

	
	@Override
	public DataResult<UpdateCarResponse> update(UpdateCarRequest updateCarRequest) {
		checkIfCarId(updateCarRequest.getId());
		checkIfCarPlateExist(updateCarRequest.getPlate());
		Car car= this.modelMapperService.forRequest().map(updateCarRequest, Car.class);
		this.carRepository.save(car);
		
		UpdateCarResponse updateCarResponse= this.modelMapperService.forResponse()
				.map(car, UpdateCarResponse.class);
		return new SuccessDataResult<UpdateCarResponse>(updateCarResponse,Messages.CarUpdated );
	}

	
	@Override
	public DataResult<GetCarResponse> getByCarId(int id) {
		checkIfCarId(id);
		Car car =this.carRepository.findById(id);
		GetCarResponse getCarResponse = this.modelMapperService.forResponse().map(car, GetCarResponse.class);
		
		return new SuccessDataResult<GetCarResponse>(getCarResponse,Messages.CarListed);
	}

	@Override
	public Result delete(int id) {
		checkIfCarId(id);
		this.carRepository.deleteById(id);
		return new SuccessResult(Messages.CarDeleted);
	}
	
	private void checkIfCarPlateExist( String plate) {
		Car car = this.carRepository.getByPlate(plate);
		if( car != null) {
			throw new BusinessException(Messages.PlateExist);			
		}
		
	}
	private void checkIfCarId( int id) {
		Car car =this.carRepository.findById(id);
		if( car == null) {
			throw new BusinessException(Messages.CarIdNotFound);
		}
	}

}
