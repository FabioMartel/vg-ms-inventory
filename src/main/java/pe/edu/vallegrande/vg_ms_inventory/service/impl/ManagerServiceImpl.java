package pe.edu.vallegrande.vg_ms_inventory.service.impl;

import pe.edu.vallegrande.vg_ms_inventory.service.ManagerService;
import pe.edu.vallegrande.vg_ms_inventory.model.Manager;
import pe.edu.vallegrande.vg_ms_inventory.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.modelmapper.ModelMapper;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public Flux<Manager> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Mono<Manager> findById(String id) {
        return managerRepository.findById(id);
    }

    @Override
    public Mono<Manager> createInventory(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        managerRepository.deleteById(id);
        return Mono.empty();
    }
}
