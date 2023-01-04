package com.kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import com.kodlama.io.rentACar.business.abstracts.BrandService;
import com.kodlama.io.rentACar.business.abstracts.ModelService;
import com.kodlama.io.rentACar.business.constants.Messages;
import com.kodlama.io.rentACar.business.requests.create.CreateModelRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateModelRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateModelResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetAllModelsResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetModelResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateModelResponse;
import com.kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import com.kodlama.io.rentACar.core.utilities.maping.ModelMapperService;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;
import com.kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import com.kodlama.io.rentACar.core.utilities.results.SuccessResult;
import com.kodlama.io.rentACar.dataAccess.ModelRepository;
import com.kodlama.io.rentACar.entities.Model;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private BrandService brandService;

	@Override
	public DataResult<List<GetAllModelsResponse>> getAll() {
		List<Model> models = this.modelRepository.findAll();
		List<GetAllModelsResponse> allModelsResponses = models.stream()
				.map(model -> this.modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllModelsResponse>>(allModelsResponses, Messages.ModelListed);
	}

	@Override
	public DataResult<CreateModelResponse> add(CreateModelRequest createModelRequest) {

		checkIfBrandId(createModelRequest.getBrandId());
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
		CreateModelResponse createModelResponse = this.modelMapperService.forResponse().map(model,
				CreateModelResponse.class);
		return new SuccessDataResult<CreateModelResponse>(createModelResponse, Messages.ModelCreated);
	}

	@Override
	public DataResult<UpdateModelResponse> update(UpdateModelRequest updateModelRequest) {
		checkIfModelId(updateModelRequest.getId());
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		UpdateModelResponse modelResponse = this.modelMapperService.forResponse().map(model, UpdateModelResponse.class);
		return new SuccessDataResult<UpdateModelResponse>(modelResponse, Messages.ModelCreated);
	}

	@Override
	public DataResult<GetModelResponse> getByModelId(int modelId) {
		Model model = this.modelRepository.findById(modelId);
		GetModelResponse getModelResponse = this.modelMapperService.forResponse().map(model, GetModelResponse.class);
		return new SuccessDataResult<GetModelResponse>(getModelResponse, Messages.ModelListed);
	}

	@Override
	public Result delete(int id) {
		checkIfModelId(id);
		this.modelRepository.deleteById(id);
		return new SuccessResult(Messages.ModelDeleted);

	}

	private void checkIfBrandId(int brandId) { // Girilen marka id si varmı?
		if (brandService.getById(brandId).getData() == null) {
			throw new BusinessException(Messages.BrandIdNotFound);
		}

	}

	private void checkIfModelId(@NotNull int id) {// girilen model id var mı?
		Model model = this.modelRepository.findById(id);
		if (model == null) {
			throw new BusinessException(Messages.ModelIdNotFound);
		}

	}

}
