package maenset.jpaap;

import maenset.jpaap.Repositories.PatientRepository;
import maenset.jpaap.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {

		SpringApplication.run(JpaApApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		patientRepository.save(new Patient(null,"Hassan",new Date(),false,56));
		patientRepository.save(new Patient(null,"Mohammed",new Date(),true,100));
		patientRepository.save(new Patient(null,"Imane",new Date(),false,210));
		List<Patient> patients = patientRepository.findAll();
		patients.forEach(p->{
			System.out.println("========================");
			System.out.println(p.getId());
			System.out.println(p.getNom());
			System.out.println(p.getScore());
			System.out.println(p.getDateNaissance());
			System.out.println(p.getMalade());
		});
		System.out.println("************************");
		Patient patient=patientRepository.findById(1L).orElse(null);
		if (patient!=null){
			System.out.println(patient.getNom());
			System.out.println(patient.getMalade());
		}
		patient.setScore(870);
		patientRepository.save(patient);
		patientRepository.deleteById(1L);
	}  
}
