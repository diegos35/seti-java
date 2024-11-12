package com.diegocaviedes.franchise.franchise_api.application.service;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.in.CreateFranchiseUseCase;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper.FranchiseMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateFranchiseService implements CreateFranchiseUseCase {

  private final FranchiseRepository franchiseRepository;
  private final FranchiseMapper franchiseMapper;

  public CreateFranchiseService(FranchiseRepository franchiseRepository,
      FranchiseMapper franchiseMapper) {
    this.franchiseRepository = franchiseRepository;
    this.franchiseMapper = franchiseMapper;
  }


  @Override
  public Mono<FranchiseDTO> createFranchise(FranchiseDTO franchiseDto) {
    Franchise franchise = franchiseMapper.toEntity(franchiseDto);
    return franchiseRepository.save(franchise);
  }

}
