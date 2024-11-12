package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductWithHighestStockDTO {

  private String branchId;
  private String productId;
  private String productName;
  private int stock;
}