package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.custom;

import reactor.core.publisher.Mono;

public interface CustomFranchiseRepository {

  Mono<Void> updateFranchiseName(String franchiseId, String name);

}
