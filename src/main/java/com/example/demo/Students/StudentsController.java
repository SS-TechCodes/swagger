package com.example.demo.Students;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/api/v1")
@RestController

public class StudentsController {
	@Autowired
	private Studentsrepository StuRepo;
	
	@GetMapping("/Students")
	public List <Students> getAllStudents(){
		
		return StuRepo.findAll();
		
	}
	@GetMapping("/students/{id}")
	public Optional<Students> getstudentsbyid(@PathVariable String id)
	{
		return StuRepo.findById(id);
	}
	@PostMapping("/students")
	public Students saveStudent(@RequestBody Students Student ) {
		return StuRepo.save(Student);
	}
	@PutMapping("/students/{id}")
	public Students updateStudent( @RequestBody Students student, @PathVariable String id)
	
	{
		Students currentStudent;
		currentStudent = StuRepo.findById(id).get();
		currentStudent.setFirstName(student.getFirstName());
		currentStudent.setLastName(student.getLastName());
		currentStudent.setStudentNumber(student.getStudentNumber());
		return StuRepo.save(currentStudent);
		
	}
	@DeleteMapping("/students/{id}")
	public void deletestudentsbyid(@PathVariable String id)
	{
		StuRepo.deleteById(id);
	}
}


