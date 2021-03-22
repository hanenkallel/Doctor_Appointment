package enet.project.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import enet.project.appointment.dao.*;
@RestController
public class SecretaryController {
	
	@Autowired
	private secretaryRepository scretaryRepository ;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainusee/p")
	@ResponseBody
	public String hello() {return "hello";}
}
