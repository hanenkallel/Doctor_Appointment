package enet.project.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/h")
	@ResponseBody
	public String hello() {return "hello";}
	
	
	@RequestMapping(value = "/savePatient", method = RequestMethod.GET)
	public Patient saveEtudiant(Patient e) {
		return patientRepository.save(e);
	}


	@RequestMapping(value = "/patients")
	public Page<Patient> listEtudiants(int page, int size) {
		return patientRepository.findAll(PageRequest.of(page, size));
	}
}
