package com.StudentService.service;

import com.StudentService.entity.Student;
import com.StudentService.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(Student student) {
        Student student1 = studentRepository.findById(student.getId()).orElse(null);
        student1.setName(student.getName());
        student1.setSurname(student.getSurname());
        student1.setAddress(student.getAddress());
        student1.setAge(student.getAge());
        return studentRepository.save(student1);
    }
}
