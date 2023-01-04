package com.kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.rentACar.business.abstracts.BrandService;
import com.kodlama.io.rentACar.business.constants.Messages;
import com.kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import com.kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import com.kodlama.io.rentACar.core.utilities.maping.ModelMapperService;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;
import com.kodlama.io.rentACar.core.utilities.results.SuccessDataResult;
import com.kodlama.io.rentACar.core.utilities.results.SuccessResult;
import com.kodlama.io.rentACar.dataAccess.BrandRepository;
import com.kodlama.io.rentACar.entities.Brand;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<List<GetAllBrandsResponse>> getAll() {
		List<Brand> brands = this.brandRepository.findAll();
		List<GetAllBrandsResponse> allBrandsResponses = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBrandsResponse>>(allBrandsResponses, Messages.BrandListed);
	}

	@Override
	public DataResult<CreateBrandResponse> add(CreateBrandRequest createBrandRequest) {
		checkIfBrandName(createBrandRequest.getBrandName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);

		CreateBrandResponse createBrandResponse = this.modelMapperService.forResponse().map(brand,
				CreateBrandResponse.class);
		return new SuccessDataResult<CreateBrandResponse>(createBrandResponse, Messages.BrandCreated);
	}

	@Override
	public DataResult<UpdateBrandResponse> update(UpdateBrandRequest updateBrandRequest) {
		checkIfBrandId(updateBrandRequest.getId());
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand);

		UpdateBrandResponse updateBrandResponse = this.modelMapperService.forResponse().map(brand,
				UpdateBrandResponse.class);
		return new SuccessDataResult<UpdateBrandResponse>(updateBrandResponse, Messages.BrandUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBrandId(id);
		this.brandRepository.deleteById(id);
		return new SuccessResult(Messages.BrandDeleted);

	}

	@Override
	public DataResult<GetBrandResponse> getById(int id) {
		checkIfBrandId(id);
		Brand brand = this.brandRepository.findById(id);
		GetBrandResponse brandResponse = this.modelMapperService.forResponse().map(brand, GetBrandResponse.class);
		return new SuccessDataResult<GetBrandResponse>(brandResponse, Messages.BrandListed);
	}

	private void checkIfBrandName(String brandName) {
		Brand brand = this.brandRepository.getByBrandName(brandName);
		if (brand != null) {
			throw new BusinessException(Messages.BrandNameExists);
		}
	}

	private void checkIfBrandId(int brandId) {
		Brand brand = this.brandRepository.findById(brandId);
		if (brand == null) {
			throw new BusinessException(Messages.BrandIdNotFound);
		}
	}

}
