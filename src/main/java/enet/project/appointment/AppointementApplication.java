package enet.project.appointment;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import enet.project.appointment.dao.appointmentRepository;
import enet.project.appointment.dao.patientRepository;
import enet.project.appointment.modele.Appointment;
import enet.project.appointment.modele.Patient;

@SpringBootApplication

public class AppointementApplication {

	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(AppointementApplication.class, args);
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		ApplicationContext ctx = SpringApplication.run(AppointementApplication.class, args);
		@SuppressWarnings("unchecked")
		patientRepository patientRepository=ctx.getBean(patientRepository.class);
		appointmentRepository appointmentRepository=ctx.getBean(appointmentRepository.class);
		patientRepository.save(new Patient( "hanen", "kallel", "29185212", "f", "sfax", "17",
				"hanen","hanen","123"));
		patientRepository.save(new Patient( "yasmine", "kallel", "29185212", "f", "sfax", "17",
				"hanen","yesmine" , "123"));
		patientRepository.save(new Patient( "yeessine", "kallel", "29185212", "f", "sfax", "17",
				"hanen","yessine","123"));
		Patient p ;
	//	p=new Patient( "hanen", "kallel", "29185212", "f", "sfax", "17",
			//	"hanen");

		appointmentRepository.save(new Appointment(df.parse("1999-12-11")));
		
		java.util.List<Patient> etds = patientRepository.findAll();
		etds.forEach(e->System.out.println(e.getNom()));
		

	}

}
