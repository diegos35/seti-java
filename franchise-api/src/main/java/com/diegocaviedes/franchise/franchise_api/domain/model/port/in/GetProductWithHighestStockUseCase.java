package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductWithHighestStockDTO;
import reactor.core.publisher.Flux;

public interface GetProductWithHighestStockUseCase {
    Flux<ProductWithHighestStockDTO> getProductWithHighestStock(String franchiseId);
}