package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto;

import lombok.Data;

@Data
public class ProductDTO {

  private String productId;
  private String name;
  private int stock;

}
