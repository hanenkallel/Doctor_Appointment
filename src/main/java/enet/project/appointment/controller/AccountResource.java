package enet.project.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import enet.project.appointment.dao.patientRepository;
import enet.project.appointment.modele.Passwordset;
import enet.project.appointment.modele.Patient;
import enet.project.appointment.service.patientService;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountResource {
	@Autowired
	private patientRepository patientRepository;
	@Autowired
	private patientService patientService;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	boolean userLogin(@RequestBody Patient user) {
		return patientService.userLogin(user);
	}

	/******************************************************************************/

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	boolean addUser(@RequestBody Patient user) {
		return patientService.addUser(user);
	}

	/******************************************************************************/

	@RequestMapping(method = RequestMethod.PUT, value = "/users/password-reset")
	public boolean matchPassword(@RequestBody Passwordset pass) {
		String password = pass.getPassword();
		String newPassword = pass.getNewpassword();
		Long userId = pass.getUserId();

		return patientService.changePassword(userId, password, newPassword);
	}
	/********************************************************************/
	
}
