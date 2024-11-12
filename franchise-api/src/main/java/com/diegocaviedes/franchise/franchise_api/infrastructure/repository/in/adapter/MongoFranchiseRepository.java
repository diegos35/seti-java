package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter;

import com.diegocaviedes.franchise.franchise_api.domain.model.Franchise;
import com.diegocaviedes.franchise.franchise_api.domain.model.port.out.FranchiseRepository;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;


@Repository
public interface MongoFranchiseRepository extends ReactiveMongoRepository<Franchise, String>,
    FranchiseRepository {

  Mono<Franchise> findById(String id);

  Mono<FranchiseDTO> save(Franchise franchise);
}
