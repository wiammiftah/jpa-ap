package maenset.hospital.services;

import maenset.hospital.entities.Consultation;
import maenset.hospital.entities.Medecin;
import maenset.hospital.entities.Patient;
import maenset.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
