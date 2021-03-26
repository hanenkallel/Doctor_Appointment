package enet.project.appointment.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import enet.project.appointment.dao.*;
import enet.project.appointment.modele.Patient;

@RestController
public class PatientController {
	@Autowired
	private patientRepository patientRepository;
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
	
}
