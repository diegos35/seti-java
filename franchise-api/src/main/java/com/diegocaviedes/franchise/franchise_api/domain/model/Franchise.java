package com.diegocaviedes.franchise.franchise_api.domain.model;

import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(toBuilder = true)
@Document(collection = "franchises")
public class Franchise {

  private String id;
  private String name;
  private List<Branch> branches;

}