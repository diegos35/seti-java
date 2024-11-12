package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto;

import java.util.List;
import lombok.Data;

@Data
public class BranchDTO {

  private String id;
  private String name;
  private List<ProductDTO> products;
}
