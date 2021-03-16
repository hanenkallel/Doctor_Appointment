package enet.project.appointment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Appointment;

@Repository
public interface appointmentRepository extends JpaRepository<Appointment,Long> {

}
