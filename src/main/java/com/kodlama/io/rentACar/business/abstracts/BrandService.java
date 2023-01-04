package com.kodlama.io.rentACar.business.abstracts;

import java.util.List;

import com.kodlama.io.rentACar.business.requests.create.CreateBrandRequest;
import com.kodlama.io.rentACar.business.requests.update.UpdateBrandRequest;
import com.kodlama.io.rentACar.business.responses.create.CreateBrandResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetAllBrandsResponse;
import com.kodlama.io.rentACar.business.responses.get.brand.GetBrandResponse;
import com.kodlama.io.rentACar.business.responses.update.UpdateBrandResponse;
import com.kodlama.io.rentACar.core.utilities.results.DataResult;
import com.kodlama.io.rentACar.core.utilities.results.Result;

public interface BrandService {
    DataResult<List<GetAllBrandsResponse>> getAll();
    DataResult<CreateBrandResponse>  add (CreateBrandRequest createBrandRequest);
    DataResult<UpdateBrandResponse>  update(UpdateBrandRequest updateBrandRequest);
    DataResult<GetBrandResponse> getById(int id);
	Result delete(int id);


}
