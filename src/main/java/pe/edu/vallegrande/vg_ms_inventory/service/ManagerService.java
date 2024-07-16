package pe.edu.vallegrande.vg_ms_inventory.service;

import pe.edu.vallegrande.vg_ms_inventory.model.Inventory;
import pe.edu.vallegrande.vg_ms_inventory.model.Manager;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ManagerService {

    Flux<Manager> findAll();
    Mono<Manager> findById(String id);
    Mono<Manager> createInventory(Manager manager);
    Mono<Void> deleteById(String id);
}
