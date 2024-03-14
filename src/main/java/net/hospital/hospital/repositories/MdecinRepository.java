package net.hospital.hospital.repositories;

import net.hospital.hospital.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MdecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);


}
