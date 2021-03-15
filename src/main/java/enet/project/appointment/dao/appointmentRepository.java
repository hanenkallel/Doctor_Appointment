package enet.project.appointment.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import enet.project.appointment.modele.Appointment;

public interface appointmentRepository extends JpaRepository<Appointment,Long> {

}
