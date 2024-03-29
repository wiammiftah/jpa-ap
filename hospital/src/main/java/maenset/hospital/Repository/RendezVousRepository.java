package maenset.hospital.Repository;

import maenset.hospital.entities.Patient;
import maenset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
}
