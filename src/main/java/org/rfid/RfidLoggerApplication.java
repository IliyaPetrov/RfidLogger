package org.rfid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RfidLoggerApplication {

	private static final Logger log = LoggerFactory.getLogger(RfidLoggerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RfidLoggerApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(EventRepository repository, TeacherRepository trepo) {
		return (args) -> {
			repository.save(new Event("137", 1234));
			repository.save(new Event("137", 1244));
			repository.save(new Event("137", 1254));
			repository.save(new Event("137", 1264));
			repository.save(new Event("137", 1278));
			repository.save(new Event("137", 1299));


			trepo.save(new Teacher("Gosho","137"));
			trepo.save(new Teacher("Pesho","150"));

//			for (Teacher teacher : trepo.findAll()) {
//				repository.findByRfidAndDateBetweenOrderByDate(teacher.getRfid(),1234L,1278L);
//			}


//			for (Event event : repository.findByRfidAndDateBetweenOrderByDate("137",1234L,1278L)) {
//				log.info(String.valueOf(event.getDate()));
//			}

			List<Event> minMax = repository.findByRfidAndDateBetweenOrderByDate("137",1234L,1278L);
            Event first = minMax.get(0);
			Event last = minMax.get(minMax.size()-1);

			log.info(String.valueOf(first.getDate()));
			log.info(String.valueOf(last.getDate()));


		};
	}
}