package com.diegocaviedes.franchise.franchise_api.domain.model;

import lombok.Data;
import lombok.Builder;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "branches")
public class Branch {

  private String id;
  private String name;
  private List<Product> products;
}