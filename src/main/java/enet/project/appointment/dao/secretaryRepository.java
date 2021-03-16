package enet.project.appointment.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import enet.project.appointment.modele.Secretary;


@Repository
public interface secretaryRepository extends JpaRepository<Secretary,Long> {

}
