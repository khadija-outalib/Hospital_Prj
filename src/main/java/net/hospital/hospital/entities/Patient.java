package net.hospital.hospital.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;


@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Patient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nom;
     private String phone;
     @Temporal(TemporalType.DATE)
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
