package enet.project.appointment.modele;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient implements Serializable {
	@Id
	@GeneratedValue
	private Long idp;
	private String nom;
	private String prenom;
	private String numTelephone;
	private String sexe;
	private String region;
	private String age;
	private String emailPatient;
	@OneToMany
	private Collection<Appointment> appointment;

	public Patient( String nom, String prenom, String numTelephone, String sexe, String region, String age,
			String emailPatient) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.numTelephone = numTelephone;
		this.sexe = sexe;
		this.region = region;
		this.age = age;
		this.emailPatient = emailPatient;
		
	}

	public Patient() {
		super();
	}

	public Long getId() {
		return idp;
	}

	public void setId(Long id) {
		this.idp = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailPatient() {
		return emailPatient;
	}

	public void setEmailPatient(String emailPatient) {
		this.emailPatient = emailPatient;
	}

	public Collection<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Collection<Appointment> appointment) {
		this.appointment = appointment;
	}

}
