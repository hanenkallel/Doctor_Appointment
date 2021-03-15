package enet.project.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import enet.project.appointment.modele.Patient;

public interface patientRepository extends JpaRepository<Patient,Long>  {

}
