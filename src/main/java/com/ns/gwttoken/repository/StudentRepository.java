package com.ns.gwttoken.repository;

import com.ns.gwttoken.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{
}
