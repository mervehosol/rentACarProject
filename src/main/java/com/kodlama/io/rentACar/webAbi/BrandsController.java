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

import com.kodlama.io.rentACar.business.abstracts.BrandService;
import com.kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
	public DataResult<List<GetAllBrandsResponse>> getAll() {
		return this.brandService.getAll();
	}

	@PostMapping()
	public DataResult<CreateBrandResponse> add(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
		return this.brandService.add(createBrandRequest);
	}

	@PutMapping()
	public DataResult<UpdateBrandResponse> update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
		return this.brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.brandService.delete(id);
	}

	@GetMapping("/{id}")
	public DataResult<GetBrandResponse> getById(@PathVariable int id) {
		return this.brandService.getById(id);
	}
}
