package net.hospital.hospital.service;

import jakarta.transaction.Transactional;
import net.hospital.hospital.entities.*;

import net.hospital.hospital.repositories.*;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {
    private final PatientRepository patientRepository;
    private final MdecinRepository medecinRepository;
    private final RendezVousRepository rendezVousRepository;
    private final ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MdecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }


@Override
public Patient updateTelPatient(String nom, String Tel) {
    Patient p = patientRepository.findByNom(nom);

    if (p!=null) {
            p.setPhone(Tel);
            return patientRepository.save(p);
    } else {

        throw new EmptyResultDataAccessException("No patient found with name: " + nom, 1);
    }
}
    @Override
    public void deletePatient(String nom) {
        Patient p = patientRepository.findByNom(nom);

        if (p!=null) {

            patientRepository.delete(p);
        } else {

            throw new EmptyResultDataAccessException("No patient found with name: " + nom, 1);
        }

    }


}
