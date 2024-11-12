package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductDTO;
import reactor.core.publisher.Mono;

public interface AddProductUseCase {

  Mono<ProductDTO> addProduct(String franchiseId, String branchId, ProductDTO productDto);

}
