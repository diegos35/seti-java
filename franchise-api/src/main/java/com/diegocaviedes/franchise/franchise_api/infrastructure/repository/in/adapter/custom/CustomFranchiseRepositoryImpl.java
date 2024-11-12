package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.custom;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CustomFranchiseRepositoryImpl implements CustomFranchiseRepository {

  private final ReactiveMongoTemplate mongoTemplate;

  @Autowired
  public CustomFranchiseRepositoryImpl(ReactiveMongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public Mono<Void> updateFranchiseName(String franchiseId, String name) {
    return mongoTemplate.findById(franchiseId, Franchise.class)
        .flatMap(franchise -> {
          franchise.setName(name);
          return mongoTemplate.save(franchise).then();
        });
  }
}
