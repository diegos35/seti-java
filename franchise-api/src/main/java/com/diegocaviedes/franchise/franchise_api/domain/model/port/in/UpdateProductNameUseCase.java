package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import reactor.core.publisher.Mono;

public interface UpdateProductNameUseCase {

  Mono<Void> updateProductName(String franchiseId, String branchId, String productId, String name);
}