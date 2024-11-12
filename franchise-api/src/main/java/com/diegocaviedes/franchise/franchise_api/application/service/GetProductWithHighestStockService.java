package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.GetProductWithHighestStockUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductWithHighestStockDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProductWithHighestStockService implements GetProductWithHighestStockUseCase {

  private final FranchiseRepository franchiseRepository;

  public GetProductWithHighestStockService(FranchiseRepository franchiseRepository) {
    this.franchiseRepository = franchiseRepository;
  }

  @Override
  public Flux<ProductWithHighestStockDTO> getProductWithHighestStock(String franchiseId) {
    return franchiseRepository.findById(franchiseId)
        .flatMapMany(franchise -> Flux.fromIterable(franchise.getBranches()))
        .flatMap(branch -> Flux.fromIterable(branch.getProducts())
            .sort((p1, p2) -> Integer.compare(p2.getStock(), p1.getStock()))
            .next()
            .map(product ->
                ProductWithHighestStockDTO.builder()
                    .branchId(branch.getId())
                    .productId(product.getProductId())
                    .productName(product.getName())
                    .stock(product.getStock())
                    .build()
            ));
  }
}