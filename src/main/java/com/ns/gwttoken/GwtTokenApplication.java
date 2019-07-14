package com.ns.gwttoken;

import com.ns.gwttoken.entity.Student;
import com.ns.gwttoken.entity.Subject;
import com.ns.gwttoken.entity.User;
import com.ns.gwttoken.repository.StudentRepository;
import com.ns.gwttoken.repository.SubjectRepository;
import com.ns.gwttoken.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GwtTokenApplication {

	public static void main(String[] args) {
		SpringApplication.run(GwtTokenApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository userRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
		return (ApplicationArguments args) ->  dataSetup(userRepository,studentRepository,subjectRepository);
	}

	private void dataSetup(UserRepository userRepository, StudentRepository studentRepository, SubjectRepository subjectRepository) {
		User niraj = new User("niraj.sonawane@gmail.com", "$2a$10$yRxRYK/s8vZCp.bgmZsD/uXmHjekuPU/duM0iPZw04ddt1ID9H7kK", "ROLE_ADMIN");
		User test = new User("test@gmail.com", "$2a$10$YWDqYU0XJwwBogVycbfPFOnzU7vsG/XvAyQlrN34G/oA1SbhRW.W.", "ROLE_USER");
		userRepository.save(niraj);
		userRepository.save(test);

		Student student1 = new Student(1L,"Ram");
		Student student2 = new Student(2L,"Sham");
		studentRepository.save(student1);
		studentRepository.save(student2);

		Subject math = new Subject(1l,"Math");
		Subject science = new Subject(2l,"Science");
		subjectRepository.save(math);
		subjectRepository.save(science);
	}

}
