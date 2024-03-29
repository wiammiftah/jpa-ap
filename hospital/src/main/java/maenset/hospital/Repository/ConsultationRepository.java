package maenset.hospital.Repository;

import maenset.hospital.entities.Consultation;
import maenset.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
