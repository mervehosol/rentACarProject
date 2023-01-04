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

import com.kodlama.io.rentACar.business.abstracts.ModelService;
import com.kodlama.io.rentACar.business.requests.create.CreateModelRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateModelRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateModelResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetAllModelsResponse;
import com.kodlama.io.rentACar.business.responses.get.model.GetModelResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateModelResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/models")
@RestController
@AllArgsConstructor
public class ModelsController {
	private ModelService modelService;
	
	   @GetMapping()
	    public DataResult<List<GetAllModelsResponse>> getAll(){
	        return this.modelService.getAll();
	    }
	   
	    @PostMapping()
	    public DataResult<CreateModelResponse> add(@Valid @RequestBody CreateModelRequest createModelRequest) {
	        return this.modelService.add(createModelRequest);
	    }
	    @PutMapping()
	    public DataResult<UpdateModelResponse> update(@Valid @RequestBody UpdateModelRequest updateModelRequest){
	        return this.modelService.update(updateModelRequest);
	    }
	    @DeleteMapping("/{id}")
	   public Result  delete(@PathVariable  int id){
	        return this.modelService.delete(id);
	   }

	    @GetMapping("/{id}")
	    public DataResult<GetModelResponse> getById(@PathVariable int id){
	        return this.modelService.getByModelId(id);
	    }
}

