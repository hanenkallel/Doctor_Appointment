package enet.project.appointment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Patient;

@Repository
public interface patientRepository extends JpaRepository<Patient, Long> {

	@Query("select u from Patient u where u.nom=?1")
	List<Patient> findByNom(String nom);

	@Query("select u from Patient u where u.idp=?1")
	List<Patient> findByPatientId(Long idp);

	@Query("select u from Patient u where  u.username=?1 and  u.password=?2 ")
	Patient findByUsernameAndPassword(String username , String password);
}
