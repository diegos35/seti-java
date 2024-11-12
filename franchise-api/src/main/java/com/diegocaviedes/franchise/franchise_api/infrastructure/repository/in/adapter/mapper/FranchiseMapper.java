package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FranchiseMapper {

  FranchiseDTO toDTO(Franchise franchise);

  Franchise toEntity(FranchiseDTO franchiseDTO);
}