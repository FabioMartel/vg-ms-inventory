package pe.edu.vallegrande.vg_ms_inventory.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.vallegrande.vg_ms_inventory.model.Manager;

@Repository
public interface ManagerRepository extends ReactiveMongoRepository<Manager, String> {
    // Métodos personalizados si son necesarios
}
