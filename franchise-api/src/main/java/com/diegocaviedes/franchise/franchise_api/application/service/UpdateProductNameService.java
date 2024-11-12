package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.UpdateProductNameUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateProductNameService implements UpdateProductNameUseCase {

  private final FranchiseRepository franchiseRepository;

  public UpdateProductNameService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<Void> updateProductName(String franchiseId, String branchId, String productId,
      String name) {
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> Mono.justOrEmpty(franchise.getBranches().stream()
                .filter(branch -> branch.getId().equals(branchId))
                .findFirst())
            .flatMap(branch -> Mono.justOrEmpty(branch.getProducts().stream()
                    .filter(product -> product.getProductId().equals(productId))
                    .findFirst())
                .flatMap(product -> {
                  product.setName(name);
                  return franchiseRepository.save(franchise).then();
                })));
  }
}