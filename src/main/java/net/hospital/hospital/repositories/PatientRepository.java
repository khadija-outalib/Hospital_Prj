package net.hospital.hospital.repositories;

import net.hospital.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient ,Long> {

   Patient findByNom(String nom);
}
