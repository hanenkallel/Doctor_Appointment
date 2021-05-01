package enet.project.appointment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import enet.project.appointment.dao.patientRepository;
import enet.project.appointment.modele.Appointment;
import enet.project.appointment.modele.Patient;

@Service
public class patientService {
	@Autowired
	patientRepository patient;

	public boolean userLogin(Patient user) {
		boolean isUserExists = false;
		Optional<Patient> log = patient.findByEmailAndPassword(user.getEmailPatient(), user.getPassword());
		if (log.isPresent()) {
			isUserExists = true;
		}

		return isUserExists;
	}

	public boolean addUser(Patient user) {
		Optional<Patient> exists = patient.findByEmail(user.getEmailPatient());
		boolean isUserExist = exists.isPresent();
		if (!isUserExist) {
			patient.save(user);
		}
		return !isUserExist;
	}

	public boolean matchPassword(Long userId, String password) {
		Optional<Patient> user = patient.findById(userId);
		// System.out.println(user.get().getPassword());
		if (password.equals(user.get().getPassword())) {
			System.out.println(user.get().getPassword());
			return true;
		}
		return false;

	}

	public boolean changePassword(Long userId, String password, String newPassword) {
		if (matchPassword(userId, password)) {
			Patient user = patient.findByPatientID(userId);
			System.out.println(newPassword);
			user.setPassword(newPassword);
			System.out.println(user.getPassword());
			patient.save(user);
			return true;
		}
		return false;
	}
	
	
	public boolean isAccepted( Appointment e) {
		if(e.getIsAccepted()) {
			System.out.println("sendmail");
			return true ;
		}
		return false ;
	}
}
