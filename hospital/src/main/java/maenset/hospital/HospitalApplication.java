package maenset.hospital;

import maenset.hospital.Repository.ConsultationRepository;
import maenset.hospital.Repository.MedecinRepository;
import maenset.hospital.Repository.PatientRepository;
import maenset.hospital.Repository.RendezVousRepository;
import maenset.hospital.entities.*;
import maenset.hospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }
    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){
        return  args -> {
            Stream.of("Mohammed","hassan","najat")
                    .forEach(name->{
                        Patient patient= new Patient();
                        patient.setNom(name);
                        patient.setDateNaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    } );
            Stream.of("aymane","hanane","yasmine")
                    .forEach(name->{
                        Medecin medecin= new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialiste(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    } );
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohammed");
            Medecin medecin=medecinRepository.findByNom("yasmine");

            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            RendezVous saveDRDV = hospitalService.saveRDV(rendezVous);
            System.out.println(saveDRDV.getId());
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);

            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation........");
            hospitalService.saveConsultation(consultation);

    };
}}
