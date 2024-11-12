package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.UpdateFranchiseUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateFranchiseService implements UpdateFranchiseUseCase {

  private final FranchiseRepository franchiseRepository;

  public UpdateFranchiseService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<Void> updateFranchiseName(String franchiseId, String name) {
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> {
          franchise.setName(name);
          return franchiseRepository.save(franchise).then();
        });
  }
}