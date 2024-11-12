package com.diegocaviedes.franchise.franchise_api.domain.model.port.out;


import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import reactor.core.publisher.Mono;

public interface FranchiseRepository {

  Mono<FranchiseDTO> save(Franchise franchise);

  Mono<Franchise> findById(String id);
}
