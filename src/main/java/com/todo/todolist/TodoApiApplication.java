package com.todo.todolist;

import com.todo.todolist.entity.Tache;
import com.todo.todolist.repository.TacheRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApiApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(TacheRepository repo) {
		return args -> {
			Tache t1 = new Tache();
			t1.setTitre("Apprendre Angular");
			repo.save(t1);

			Tache t2 = new Tache();
			t2.setTitre("Apprendre Spring Boot");
			t2.setTerminee(true);
			repo.save(t2);
		};
	}
}