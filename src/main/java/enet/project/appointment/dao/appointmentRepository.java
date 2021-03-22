package enet.project.appointment.dao;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Appointment;
import enet.project.appointment.modele.Patient;

@Repository
public interface appointmentRepository extends JpaRepository<Appointment,Long> {
	
	@Query("select u from Appointment u where u.id=?1")
	List<Appointment> findByAppointmentId(Long id);
	
	
	@Query("select u from Appointment u where u.dateRdv=?1")
	List<Appointment> findByAppointmentDate(Date dateRdv);

}
