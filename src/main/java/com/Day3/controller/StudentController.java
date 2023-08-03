package com.Day3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Day3.entity.Student;
import com.Day3.service.StudentService;

@Controller
public class StudentController {


	@Autowired
	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/students")
	public String listStudent(Model model)
	{
		model.addAttribute("students", studentService.getAllstudents());
		return "students";
	}

	@GetMapping("/students/new")
	public String createStudentForm(Model model)
	{
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student)
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}

	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model)
	{
	model.addAttribute("student",studentService.getStudentById(id));
	return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute Student student)
	{
		//get student from database by id
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());

		//save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";


	}

	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id)
	{
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}


}

