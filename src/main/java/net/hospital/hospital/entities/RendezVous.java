package net.hospital.hospital.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class RendezVous {
    @Id
    private String id;
    private Date  date;

    @Enumerated(EnumType.STRING)
    private  StatusRDV  Status;


    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  Patient patient;

    @ManyToOne
    private  Medecin medecin;

    @OneToOne (mappedBy = "rendezVous")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Consultation consultation;

    public RendezVous(Date date, StatusRDV Status, Patient patient, Medecin medecin) {
        this.date = date;
        this.Status = Status;
        this.patient = patient;
        this.medecin = medecin;
    }
}
