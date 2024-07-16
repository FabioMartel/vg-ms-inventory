package pe.edu.vallegrande.vg_ms_inventory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "inventory")
public class Inventory {
    @Id
    private String id;
    private String area;
    private String code;
    private String description;
    private String amount;
    private String modality;
    private LocalDate date;
    private String status;
    private String manager_id;
}
