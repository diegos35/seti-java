package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper;

import com.diegocaviedes.franchise.franchise_api.domain.model.Branch;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.BranchDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BranchMapper {

  BranchDTO toDTO(Branch branch);

  Branch toEntity(BranchDTO branchDTO);
}