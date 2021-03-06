package enet.project.appointment;



import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import enet.project.appointment.controller.AccountResource;
import enet.project.appointment.controller.AppointmentController;
import enet.project.appointment.dao.appointmentRepository;
import enet.project.appointment.dao.patientRepository;
import enet.project.appointment.modele.Appointment;

import enet.project.appointment.modele.Patient;

@SpringBootApplication

public class AppointementApplication {

    @Autowired
    private SendEmailService SendEmailService;

	
	public static void main(String[] args) throws ParseException {
		SpringApplication.run(AppointementApplication.class, args);
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		ApplicationContext ctx = SpringApplication.run(AppointementApplication.class, args);
		@SuppressWarnings("unchecked")
		patientRepository patientRepository=ctx.getBean(patientRepository.class);
		appointmentRepository appointmentRepository=ctx.getBean(appointmentRepository.class);
		//patientRepository.save( new Patient( "yasmine", "kallel", "29185212", "12/4/1998", "sfax", "17",
				//"kallelyasmine356@gmail.com","123"));
		//patientRepository.save(new Patient( "hanen", "kallel", "29185212", "f", "sfax", "17",
				//"hanenkallel15@gmail.com","123"));
		//patientRepository.save(new Patient( "yessine", "kallel", "29185212", "f", "sfax", "17",
				//"yessinekallel103@gmail.com","123"));
		
		 final String username = "cesarapo525@gmail.com"
		 		;
	        final String password = "Supermario007";
		
		Properties props = new Properties();
		
		 Session session = Session.getDefaultInstance(props,
	                new javax.mail.Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(username,password);
	                    }
	                });
	//	patientRepository.save(new Patient( "yasmine", "kallel", "29185212", "f", "sfax", "17",
		//		"hanen"));
		//patientRepository.save(new Patient( "yeessine", "kallel", "29185212", "f", "sfax", "17",
		//		"hanen"));
		
	//	p=new Patient( "hanen", "kallel", "29185212", "f", "sfax", "17",
			//	"hanen");

		appointmentRepository.save(new Appointment(df.parse("1999-12-11")));
		
		//java.util.List<Patient> etds = patientRepository.findAll();
		//etds.forEach(e->System.out.println(e.getNom()));
		
		//Patient patient = patientRepository.findByNom("hanen");
		//System.out.println(patient.getNom());

		
		//Login name=new Login () ; 
		//name.setUserName("hanen");
		//name.setPassword("125");
		//AccountResource account =new AccountResource() ; 
		//account.loginProcess(name);
		//AppointmentController a=new AppointmentController() ; 
		//Appointment app= a.findByAppointmentId((long) 1) ;
		//System.out.println(app.getDateRdv());
		
		
	
		//Patient patient = patientRepository.findByNom(name.getUserName());
		//System.out.println(patient.getNom());
	   //if (patient.getPassword().equals(name.getPassword()))
	   //{
		  // System.out.println("connected");
	  // }
	  // else 
	   //{
		//AccountResource account = new AccountResource() ; 
		//System.out.println(account.loginProcess(name));
		
	
		
		   //System.out.println("Password rong");}
		

	//}
	
}
	
	//@EventListener(ApplicationReadyEvent.class)
	   //public String mes() {

	       // SendEmailService.sendMail("hanenkallel15@gmail.com", "Test Subject", "Test mail");
//return "good";
	     
	   // }
	

}