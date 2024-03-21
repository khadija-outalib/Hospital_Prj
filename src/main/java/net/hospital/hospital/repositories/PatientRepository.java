package net.hospital.hospital.repositories;

import net.hospital.hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.PriorityQueue;

public interface PatientRepository extends JpaRepository<Patient ,Long> {

   Patient findByNom(String nom);
   Page<Patient> findByNomContainsIgnoreCase(String keyword, Pageable pageable);
}
