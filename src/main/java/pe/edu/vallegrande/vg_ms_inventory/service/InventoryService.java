package pe.edu.vallegrande.vg_ms_inventory.service;

import pe.edu.vallegrande.vg_ms_inventory.model.Inventory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface InventoryService {
    Flux<Inventory> findAll();
    Flux<Inventory> findByStatus(String status);
    Flux<Inventory> getInventoriesWithStatusM();
    Flux<Inventory> createInventory(Inventory inventory);
    Mono<Inventory> deleteInventory(String id);
    Mono<Inventory> updateInventory(String id, Inventory inventory);
    Mono<Inventory> findAttorneyById(String id);

}
