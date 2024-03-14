package net.hospital.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Consultation {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    private Date dateConsultation;
    private String rapport;

    @OneToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private RendezVous rendezVous;

    public Consultation(Date dateConsultation, String rapport, RendezVous rendezVous) {
        this.dateConsultation = dateConsultation;
        this.rapport = rapport;
        this.rendezVous = rendezVous;
    }
}

