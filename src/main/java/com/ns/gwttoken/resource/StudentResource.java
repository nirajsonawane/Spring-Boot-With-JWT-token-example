package com.ns.gwttoken.resource;

import com.ns.gwttoken.entity.Student;
import com.ns.gwttoken.repository.StudentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Student")
public class StudentResource {

private final StudentRepository studentRepository;

    public StudentResource(StudentRepository studentRepository) {
        this.studentRepository=studentRepository;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
}
