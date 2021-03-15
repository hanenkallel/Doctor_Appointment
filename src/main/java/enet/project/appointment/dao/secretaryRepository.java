package enet.project.appointment.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import enet.project.appointment.modele.Secretary;

public interface secretaryRepository extends JpaRepository<Secretary,Long> {

}
