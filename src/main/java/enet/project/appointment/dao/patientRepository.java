package enet.project.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Patient;


@Repository
public interface patientRepository extends JpaRepository<Patient,Long>  {

}
