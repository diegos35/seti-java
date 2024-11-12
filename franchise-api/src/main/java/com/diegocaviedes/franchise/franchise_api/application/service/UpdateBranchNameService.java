package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.UpdateBranchNameUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateBranchNameService implements UpdateBranchNameUseCase {

  private final FranchiseRepository franchiseRepository;

  public UpdateBranchNameService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<Void> updateBranchName(String franchiseId, String branchId, String name) {
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> Mono.justOrEmpty(franchise.getBranches().stream()
                .filter(branch -> branch.getId().equals(branchId))
                .findFirst())
            .flatMap(branch -> {
              branch.setName(name);
              return franchiseRepository.save(franchise).then();
            }));
  }
}