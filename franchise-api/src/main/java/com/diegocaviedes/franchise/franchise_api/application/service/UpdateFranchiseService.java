package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.UpdateFranchiseUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateFranchiseService implements UpdateFranchiseUseCase {

  private final FranchiseRepository franchiseRepository;

  public UpdateFranchiseService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<FranchiseDTO> updateFranchise(Franchise franchise) {
    return franchiseRepository.save(franchise);
  }
}