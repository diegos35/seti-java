package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.Branch;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.AddBranchUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.BranchDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper.BranchMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AddBranchService implements AddBranchUseCase {

  private final FranchiseRepository franchiseRepository;
  private final BranchMapper branchMapper;


  public AddBranchService(FranchiseRepository franchiseRepository, BranchMapper branchMapper) {
    this.franchiseRepository = franchiseRepository;
    this.branchMapper = branchMapper;
  }


  @Override
  public Mono<BranchDTO> addBranch(String franchiseId, BranchDTO branchDTO) {
    Branch branch = branchMapper.toEntity(branchDTO);
    return franchiseRepository.findById(franchiseId)
        .flatMap(franchise -> {
          franchise.getBranches().add(branch);
          return franchiseRepository.save(franchise).thenReturn(branchMapper.toDTO(branch));
        });
  }

}
