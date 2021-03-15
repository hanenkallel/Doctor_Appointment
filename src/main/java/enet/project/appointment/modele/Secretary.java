package enet.project.appointment.modele;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Secretary implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String nomMedecin;
	private String prenomMedecin;
	private String numTelephone;
	private String sexe;
	private String age;

	public Secretary() {
		super();
	}

	public Secretary(String nomMedecin, String prenomMedecin, String numTelephone, String sexe, String age,
			String emailCabinet) {
		super();
		this.nomMedecin = nomMedecin;
		this.prenomMedecin = prenomMedecin;
		this.numTelephone = numTelephone;
		this.sexe = sexe;
		this.age = age;
		this.emailCabinet = emailCabinet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public String getPrenomMedecin() {
		return prenomMedecin;
	}

	public void setPrenomMedecin(String prenomMedecin) {
		this.prenomMedecin = prenomMedecin;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailCabinet() {
		return emailCabinet;
	}

	public void setEmailCabinet(String emailCabinet) {
		this.emailCabinet = emailCabinet;
	}

	public Collection<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Collection<Appointment> appointments) {
		this.appointments = appointments;
	}

	private String emailCabinet;
	@OneToMany
	private Collection<Appointment> appointments;

}
