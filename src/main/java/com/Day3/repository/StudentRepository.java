package com.Day3.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Day3.entity.Student;



public interface StudentRepository extends JpaRepository<Student, Long>{

}