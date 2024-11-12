package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import reactor.core.publisher.Mono;

public interface UpdateStockUseCase {

  Mono<Void> updateStock(String franchiseId, String branchId, String productId, int stock);

}
