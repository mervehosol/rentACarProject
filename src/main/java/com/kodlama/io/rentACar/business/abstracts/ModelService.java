package com.kodlama.io.rentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.rentACar.business.requests.create.CreateModelRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateModelRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateModelResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetAllModelsResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetModelResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateModelResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

public interface ModelService {
	DataResult<List<GetAllModelsResponse>> getAll();
    DataResult<CreateModelResponse>  add (CreateModelRequest createModelRequest);
    DataResult<UpdateModelResponse>  update(UpdateModelRequest updateModelRequest);
    DataResult<GetModelResponse> getByModelId(int modelId);
	Result delete(int id);

}
