package com.diegocaviedes.franchise.franchise_api.domain.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "products")
public class Product {

  private String id;
  private String name;
  private int stock;
}