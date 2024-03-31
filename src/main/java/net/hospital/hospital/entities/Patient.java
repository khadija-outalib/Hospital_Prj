package net.hospital.hospital.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Collection;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
    @NotEmpty
    @Size(min =3 ,max =15)
     private String nom;
    @Size(min=10,max=15)
     private String phone;
     @Temporal(TemporalType.DATE)
     @DateTimeFormat(pattern = "yyyy-MM-dd")
    private  Date dateNaissanec;
    private  boolean  malade ;

    @OneToMany(mappedBy = "patient" ,fetch = FetchType.LAZY)
   private  Collection<RendezVous> rendezVous;

    public Patient(String nom, Date dateNaissanec, boolean malade,String phone) {
        this.nom = nom;
        this.dateNaissanec = dateNaissanec;
        this.malade = malade;
        this.phone=phone;
    }
}
