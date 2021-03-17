package enet.project.appointment;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import enet.project.appointment.dao.patientRepository;
import enet.project.appointment.modele.Patient;

@SpringBootApplication

public class AppointementApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(AppointementApplication.class, args);
	
		ApplicationContext ctx = SpringApplication.run(AppointementApplication.class, args);
		@SuppressWarnings("unchecked")
		patientRepository patientRepository=ctx.getBean(patientRepository.class);
		
		patientRepository.save(new Patient( "hanen", "kallel", "29185212", "f", "sfax", "17",
				"hanen"));
		patientRepository.save(new Patient( "yasmine", "kallel", "29185212", "f", "sfax", "17",
				"hanen"));
		patientRepository.save(new Patient( "yeessine", "kallel", "29185212", "f", "sfax", "17",
				"hanen"));
		
		
		java.util.List<Patient> etds = patientRepository.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
		

	}

}
