package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import reactor.core.publisher.Mono;

public interface UpdateBranchNameUseCase {

  Mono<Void> updateBranchName(String franchiseId, String branchId, String name);
}