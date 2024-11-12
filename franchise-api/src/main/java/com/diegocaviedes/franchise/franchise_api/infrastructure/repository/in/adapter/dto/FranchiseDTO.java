package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class FranchiseDTO {

  private String id;
  private String name;
  private List<BranchDTO> branches;
}
