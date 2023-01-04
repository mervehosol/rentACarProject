package com.kodlama.io.rentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.rentACar.business.requests.create.CreateCarRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateCarRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateCarResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetAllCarsResponse;
import com.kodlama.io.rentACar.business.responses.get.car.GetCarResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateCarResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

public interface CarService {
	DataResult<List<GetAllCarsResponse>> getAll();
    DataResult<CreateCarResponse>  add (CreateCarRequest createCarRequest);
    DataResult<UpdateCarResponse>  update(UpdateCarRequest updateCarRequest);
    DataResult<GetCarResponse> getByCarId(int id);
	Result delete(int id);

}
