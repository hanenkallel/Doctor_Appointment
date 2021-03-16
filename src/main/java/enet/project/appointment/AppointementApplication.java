package enet.project.appointment;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Transactional
public class AppointementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointementApplication.class, args);

	}

}
