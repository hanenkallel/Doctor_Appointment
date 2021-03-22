package enet.project.appointment.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import enet.project.appointment.dao.*;
import enet.project.appointment.modele.Appointment;
import enet.project.appointment.modele.Patient;

@RestController
public class AppointmentController {
	@Autowired
	private appointmentRepository appointmentRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainusee")
	@ResponseBody
	public String hello() {
		return "hello";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse/app/{id}")
	List<Appointment> findByAppointmentId(@PathVariable Long id) {
		return appointmentRepository.findByAppointmentId(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse/Appointments")
	public List<Appointment> listAppointment() {
		return appointmentRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse/rdv/{dateRdv}")
	List<Appointment> findByAppointmentDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date dateRdv) {
		return appointmentRepository.findByAppointmentDate(dateRdv);
	}

	@DeleteMapping("/api/javainuse/appointment/{id}")
	public void DeleteReservation(@PathVariable(value = "id") Long id) {
		appointmentRepository.deleteById(id);
	}
	@RequestMapping( method = RequestMethod.POST,value = "/api/javainuse/save/{a}")
	public Appointment saveAppointment( @PathVariable Appointment a) {
		return appointmentRepository.save(a);
	}

}
