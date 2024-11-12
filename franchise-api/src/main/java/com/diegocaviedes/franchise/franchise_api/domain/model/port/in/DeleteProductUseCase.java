package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import reactor.core.publisher.Mono;

public interface DeleteProductUseCase {

  Mono<Void> deleteProduct(String franchiseId, String branchId, String productId);
}