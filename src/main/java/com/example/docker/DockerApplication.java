package com.example.docker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DockerApplication.class);

	@Value("${input.value}")
	private String inputValue;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		runJDBC();
		log.info("inputValue " + inputValue);
		log.info("Test Build Changed ");
		log.info("Test Build Changed12233 ");
	}

	void runJDBC() {

		log.info("Creating tables for testing...");

		jdbcTemplate.execute("DROP TABLE IF EXISTS books");
		jdbcTemplate.execute("CREATE TABLE books(" +
				"id SERIAL, name VARCHAR(255), price NUMERIC(15, 2))");
		log.info("Done...");


	}
}
