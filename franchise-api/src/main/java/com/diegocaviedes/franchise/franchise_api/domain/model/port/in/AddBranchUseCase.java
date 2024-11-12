package com.diegocaviedes.franchise.franchise_api.domain.model.port.in;

import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.BranchDTO;
import reactor.core.publisher.Mono;

public interface AddBranchUseCase {

  Mono<BranchDTO> addBranch(String franchiseId, BranchDTO branchDTO);
}