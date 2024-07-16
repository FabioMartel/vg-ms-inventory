package pe.edu.vallegrande.vg_ms_inventory.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.vg_ms_inventory.model.Inventory;
import pe.edu.vallegrande.vg_ms_inventory.service.impl.InventoryServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/inventory")
public class InventoryRest {

    private  final InventoryServiceImpl InventoryService;

    @Autowired
    public InventoryRest(InventoryServiceImpl InventoryService) {
        this.InventoryService = InventoryService;
    }

    @GetMapping
    public Flux <Inventory> getAllInventories() {
        return InventoryService.findAll();
    }

    @GetMapping("/status/M")
    public Flux <Inventory> getInventoriesWithStatusM() {
        return InventoryService.findByStatus("M");
    }


    @PostMapping
    public Flux<Inventory> createInventory(@RequestBody Inventory inventory) {
        return InventoryService.createInventory(inventory);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Inventory>> deleteInventory(@PathVariable String id) {
        return InventoryService.deleteInventory(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public Mono<ResponseEntity<Inventory>> updateInventory(@PathVariable String id, @RequestBody Inventory inventory) {
        return InventoryService.updateInventory(id, inventory)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
}

    @GetMapping("/{id}")
    public Mono<Inventory> getAttorneyById(@PathVariable String id) {
        return InventoryService.findAttorneyById(id);
}

}