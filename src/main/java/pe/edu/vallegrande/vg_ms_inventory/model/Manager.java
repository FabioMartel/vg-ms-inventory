package pe.edu.vallegrande.vg_ms_inventory.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "manager")
public class Manager {
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String rol;
    private String documenttype;
    private String documentnumber;
    private LocalDate birthdate;
    private String cellphone;
    private String email;
    private String residence;
    private String status;
}
