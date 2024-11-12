package com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter;

import com.diegocaviedes.franchise.franchise_api.application.service.*;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.BranchDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.FranchiseDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.ProductWithHighestStockDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.UpdateBranchNameDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.UpdateFranchiseNameDTO;
import com.diegocaviedes.franchise.franchise_api.infrastructure.repository.in.adapter.dto.UpdateProductNameDTO;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1/franchise")
public class FranchiseController {

  private final CreateFranchiseService createFranchiseService;
  private final UpdateFranchiseService updateFranchiseService;
  private final AddBranchService addBranchService;
  private final AddProductService addProductService;
  private final UpdateStockService updateStockService;
  private final UpdateBranchNameService updateBranchNameService;
  private final UpdateProductNameService updateProductNameService;
  private final DeleteProductService deleteProductService;
  private final GetProductWithHighestStockService getProductWithHighestStockService;

  public FranchiseController(CreateFranchiseService createFranchiseService,
      UpdateFranchiseService updateFranchiseService, AddBranchService addBranchService,
      AddProductService addProductService, UpdateStockService updateStockService,
      UpdateBranchNameService updateBranchNameService,
      UpdateProductNameService updateProductNameService, DeleteProductService deleteProductService,
      GetProductWithHighestStockService getProductWithHighestStockService) {
    this.createFranchiseService = createFranchiseService;
    this.updateFranchiseService = updateFranchiseService;
    this.addBranchService = addBranchService;
    this.addProductService = addProductService;
    this.updateStockService = updateStockService;
    this.updateBranchNameService = updateBranchNameService;
    this.updateProductNameService = updateProductNameService;
    this.deleteProductService = deleteProductService;
    this.getProductWithHighestStockService = getProductWithHighestStockService;
  }


  @PostMapping
  public Mono<FranchiseDTO> createFranchise(@RequestBody FranchiseDTO franchise) {
    return createFranchiseService.createFranchise(franchise);
  }

  @PutMapping("/{franchiseId}/name")
  public Mono<Void> updateFranchise(@PathVariable String franchiseId,
      @RequestBody UpdateFranchiseNameDTO updateFranchiseNameDto) {
    return updateFranchiseService.updateFranchiseName(franchiseId,
        updateFranchiseNameDto.getName());
  }

  @PostMapping("/{franchiseId}/branch")
  public Mono<BranchDTO> addBranch(@PathVariable String franchiseId,
      @RequestBody BranchDTO branchDTO) {
    return addBranchService.addBranch(franchiseId, branchDTO);
  }

  @PostMapping("/{franchiseId}/branch/{branchId}/product")
  public Mono<ProductDTO> addProduct(@PathVariable String franchiseId,
      @PathVariable String branchId,
      @RequestBody ProductDTO productDto) {
    return addProductService.addProduct(franchiseId, branchId, productDto);
  }

  @PutMapping("/{franchiseId}/branch/{branchId}/product/{productId}/stock")
  public void updateStock(@PathVariable String franchiseId, @PathVariable String branchId,
      @PathVariable String productId, @RequestParam int stock) {
    updateStockService.updateStock(franchiseId, branchId, productId, stock);
  }

  @PutMapping("/{franchiseId}/branch/{branchId}/name")
  public Mono<Void> updateBranchName(@PathVariable String franchiseId,
      @PathVariable String branchId,
      @RequestBody UpdateBranchNameDTO updateBranchNameDTO) {
    return updateBranchNameService.updateBranchName(franchiseId, branchId,
        updateBranchNameDTO.getName());
  }

  @PutMapping("/{franchiseId}/branch/{branchId}/product/{productId}/name")
  public Mono<Void> updateProductName(@PathVariable String franchiseId,
      @PathVariable String branchId,
      @PathVariable String productId,
      @RequestBody UpdateProductNameDTO updateProductNameDTO) {
    return updateProductNameService.updateProductName(franchiseId, branchId, productId,
        updateProductNameDTO.getName());
  }

  @DeleteMapping("/{franchiseId}/branch/{branchId}/product/{productId}")
  public Mono<Void> deleteProduct(@PathVariable String franchiseId,
      @PathVariable String branchId,
      @PathVariable String productId) {
    return deleteProductService.deleteProduct(franchiseId, branchId, productId);
  }

  @GetMapping("/{franchiseId}/products/highest-stock")
  public Flux<ProductWithHighestStockDTO> getProductWithHighestStock(
      @PathVariable String franchiseId) {
    return getProductWithHighestStockService.getProductWithHighestStock(franchiseId);
  }
}