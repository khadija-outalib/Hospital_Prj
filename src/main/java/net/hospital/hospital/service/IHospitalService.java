package net.hospital.hospital.service;

import net.hospital.hospital.entities.*;

public interface IHospitalService {

    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRendezVous(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);

    Patient updateTelPatient (String nom , String Tel);

    void deletePatient (String nom);

    void deleteById(Long id);


}
