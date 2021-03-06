package enet.project.appointment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import enet.project.appointment.modele.MailRequest;
import enet.project.appointment.modele.MailResponse;
import enet.project.appointment.SendEmailService;
import enet.project.appointment.dao.*;
import enet.project.appointment.modele.Patient;
import enet.project.appointment.modele.register;
import enet.project.appointment.service.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class PatientController {
	@Autowired
	private patientRepository patientRepository;
	
	@Autowired
	private EmailService service;
	
	 private SendEmailService SendEmailService;
	/***
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainusee")
	@ResponseBody
	public String hello() {return "hello";}***/
	
	
	@RequestMapping(method = RequestMethod.POST ,value = "/api/javainuse/savepatient"
)
	public Patient saveEtudiant( @RequestBody Patient e) {
		return patientRepository.save(e);
	}


	@RequestMapping(method = RequestMethod.GET , value = "/api/javainuse/patients")
	public  List<Patient> listPatient() {
		return (List<Patient>) patientRepository.findAll();
	}
	@RequestMapping(method = RequestMethod.GET , value = "/api/javainuse/{nom}")
	public Patient findByNom(@PathVariable String nom){
		return patientRepository.findByNom(nom);
		
	}
	@RequestMapping(method = RequestMethod.GET , value = "/api/javainuse/patient/{idp}")
	List<Patient> findByPatientId(@PathVariable Long idp){
		return patientRepository.findByPatientId(idp);
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/api/javainuse/patient/login/{username}/{password}")
	Optional<Patient> findByUsernameAndPassword(@PathVariable String email ,@PathVariable String password ){
		return patientRepository.findByEmailAndPassword(email,password );
	}
	
	@DeleteMapping("/api/javainuse/patient/del/{id}")
	public void DeletePatient(@PathVariable(value = "id") String id) {
		Long idp=Long.parseLong(id);
		patientRepository.deleteById(idp);
	}
	
	@PostMapping("/sendingEmail/{id}")
	public MailResponse sendEmail(@PathVariable(value = "id") String id) {
		Long idp=Long.parseLong(id);
		Patient user= patientRepository.findByPatientID(idp) ; 
		  //SendEmailService.sendMail("hanenkallel15@gmail.com", "Test Subject", "Test mail");
		System.out.println(user.getEmailPatient());
		MailRequest request = new MailRequest() ;  ;
		request.setTo(user.getEmailPatient());
	    request.setFrom("cesarapo525@gmail.com");
	    request.setSubject("APPOINTMENT");
	    request.setName(user.getNom());
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Tunisia,sfax");
		model.put("date", user.getDateRdv());
	
	   
		return service.sendEmail(request, model);
		
		

		
	}
	


	
}
