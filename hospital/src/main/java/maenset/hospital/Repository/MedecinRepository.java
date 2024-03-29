package maenset.hospital.Repository;

import maenset.hospital.entities.Medecin;
import maenset.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
