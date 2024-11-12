package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import reactor.core.publisher.Mono;

public interface CreateFranchiseUseCase {

  Mono<FranchiseDTO> createFranchise(FranchiseDTO franchiseDto);

}
