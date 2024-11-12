package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.DeleteProductUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductService implements DeleteProductUseCase {


  private final FranchiseRepository franchiseRepository;

  public DeleteProductService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Mono<Void> deleteProduct(String franchiseId, String branchId, String productId) {
    return franchiseRepository.findById(franchiseId)
        .switchIfEmpty(Mono.error(new RuntimeException("Franchise not found")))
        .flatMap(franchise -> Mono.justOrEmpty(franchise.getBranches().stream()
                .filter(branch -> branch.getId().equals(branchId))
                .findFirst())
            .switchIfEmpty(Mono.error(new RuntimeException("Branch not found")))
            .flatMap(branch -> {
              boolean removed = branch.getProducts()
                  .removeIf(product -> product.getProductId().equals(productId));
              if (!removed) {
                return Mono.error(new RuntimeException("Product not found"));
              }
              return franchiseRepository.save(franchise).then();
            }));
  }

}
