package com.Day3.service;

import java.util.List;

import com.Day3.entity.Student;

public interface StudentService {

	public List<Student> getAllstudents();

	public Student saveStudent(Student student);

	public Student getStudentById(Long id);

	public Student updateStudent(Student student);

	public void deleteStudentById(Long id);
}
