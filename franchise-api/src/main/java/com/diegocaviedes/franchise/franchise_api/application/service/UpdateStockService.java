package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.Branch;
import com.diegocaviedes.franchise.franchise_api.domain.model.Product;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.UpdateStockUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UpdateStockService implements UpdateStockUseCase {

  private final FranchiseRepository franchiseRepository;

  public UpdateStockService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<Void> updateStock(String franchiseId, String branchId, String productId, int stock) {
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> {
          franchise.getBranches().stream()
              .filter(branch -> branch.getId().equals(branchId))
              .findFirst()
              .ifPresent(branch -> {
                branch.getProducts().stream()
                    .filter(product -> product.getId().equals(productId))
                    .findFirst()
                    .ifPresent(product -> product.setStock(stock));
              });
          return franchiseRepository.save(franchise).then();

        });
  }
}
