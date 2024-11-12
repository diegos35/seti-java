package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.mapper;

import com.diegocaviedes.franchise.franchise_api.domain.model.Product;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductDTO toDTO(Product product);

  Product toEntity(ProductDTO productDTO);
}