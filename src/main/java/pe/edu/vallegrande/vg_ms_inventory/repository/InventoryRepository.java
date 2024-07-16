package pe.edu.vallegrande.vg_ms_inventory.repository;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pe.edu.vallegrande.vg_ms_inventory.model.Inventory;
import reactor.core.publisher.Flux;

import java.util.List;

public interface InventoryRepository extends ReactiveMongoRepository  <Inventory, String>{

    Flux<Inventory> findByDescription(String description);
    Flux<Inventory> findByArea(String area);
    Flux<Inventory> findByCode(String code);
    Flux<Inventory> findByStatus (String status);
    Flux<Inventory> findByStatusIn(List<String> statuses);
}
