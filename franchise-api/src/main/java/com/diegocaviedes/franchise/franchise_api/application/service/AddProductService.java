package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.Branch;
import com.diegocaviedes.franchise.franchise_api.domain.model.Product;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.AddProductUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddProductService implements AddProductUseCase {

  private final FranchiseRepository franchiseRepository;
  private final ProductMapper productMapper;

  public AddProductService(FranchiseRepository franchiseRepository, ProductMapper productMapper) {
    this.franchiseRepository = franchiseRepository;
    this.productMapper = productMapper;
  }


  @Override
  public Mono<ProductDTO> addProduct(String franchiseId, String branchId, ProductDTO productDto) {
    Product product = productMapper.toEntity(productDto);
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> {
          for (Branch branch : franchise.getBranches()) {
            if (branch.getId().equals(branchId)) {
              branch.getProducts().add(product);
              return franchiseRepository.save(franchise).thenReturn(productMapper.toDTO(product));
            }
          }
          return Mono.empty();
        });
  }
}
