package pe.edu.vallegrande.vg_ms_inventory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.vallegrande.vg_ms_inventory.model.Inventory;
import pe.edu.vallegrande.vg_ms_inventory.repository.InventoryRepository;
import pe.edu.vallegrande.vg_ms_inventory.service.InventoryService;
import static pe.edu.vallegrande.vg_ms_inventory.util.Inventory.Activo;
import static pe.edu.vallegrande.vg_ms_inventory.util.Inventory.Inactivo;
import pe.edu.vallegrande.vg_ms_inventory.service.ManagerService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository InventoryRepository;
    private final ManagerService managerService;
    private final ModelMapper modelMapper =new ModelMapper();

    @Autowired
    public InventoryServiceImpl(InventoryRepository AttorneyRepository, ManagerService managerService) {
        this.InventoryRepository = AttorneyRepository;
        this.managerService = managerService;
    }

    @Override
    public Flux<Inventory> findAll() {
        return InventoryRepository.findAll();
    }

    @Override
    public Flux<Inventory> findByStatus(String status) {
        return InventoryRepository.findByStatus(status);
    }

    @Override
    public Mono<Inventory> updateInventory(String id, Inventory inventory) {
        return InventoryRepository.findById(id)
                .flatMap(existingInventory -> {
                    existingInventory.setArea(inventory.getArea());
                    existingInventory.setCode(inventory.getCode());
                    existingInventory.setDescription(inventory.getDescription());
                    existingInventory.setAmount(inventory.getAmount());
                    existingInventory.setModality(inventory.getModality());
                    existingInventory.setStatus(inventory.getStatus());
                    existingInventory.setManager_id(inventory.getManager_id());
                    return InventoryRepository.save(existingInventory);
                })
                .switchIfEmpty(Mono.error(new RuntimeException("Inventory ID no encontrado: " + id)));
    }

    @Override
    public Flux<Inventory> getInventoriesWithStatusM (){
        return InventoryRepository.findByStatus(Inactivo);
    }

    @Override
    public Flux<Inventory> createInventory(Inventory inventory) {
        // Validar que el manager_id existe en la colección manager
        return managerService.findById(inventory.getManager_id())
                .flatMap(manager -> InventoryRepository.save(inventory))
                .switchIfEmpty(Mono.error(new RuntimeException("Manager ID no encontrado: " + inventory.getManager_id())))
                .flux();
    }

    @Override
    public Mono<Inventory> deleteInventory(String id) {
        return InventoryRepository.findById(id)
                .flatMap(existingAttorney -> {
                    existingAttorney.setStatus(Inactivo);
                    return InventoryRepository.save(existingAttorney);
                });
    }


    @Override
    public Mono<Inventory> findAttorneyById(String id) {
        return InventoryRepository.findById(id);
    }

}
