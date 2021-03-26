package enet.project.appointment.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Patient;

@Repository
public interface patientRepository extends CrudRepository<Patient, Long> {

	@Query("select u from Patient u where u.nom=?1")
	Patient findByNom(String nom);

	@Query("select u from Patient u where u.idp=?1")
	List<Patient> findByPatientId(Long idp);

	@Query("select u from Patient u where  u.emailPatient=?1 and  u.password=?2 ")
	Optional <Patient> findByEmailAndPassword(String email , String password);
	
	@Query("select u from Patient u where  u.emailPatient=?1 ")
	Optional <Patient> findByEmail(String email );
	
	@Query("select u from Patient u where u.idp=?1")
	Optional<Patient> findById(Long idp);


	@Query("select u from Patient u where u.idp=?1")
	Patient findByPatientID(Long idp);

	
	
	
	
	
}
