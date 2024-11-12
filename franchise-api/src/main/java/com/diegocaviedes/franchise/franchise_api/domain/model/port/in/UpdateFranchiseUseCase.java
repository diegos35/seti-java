package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import reactor.core.publisher.Mono;

public interface UpdateFranchiseUseCase {

  Mono<Void> updateFranchiseName(String franchiseId, String name);
}
