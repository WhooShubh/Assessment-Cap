package com.example.StudentManagementSystem.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.StudentManagementSystem.entity.Student;
import com.example.StudentManagementSystem.exception.StudentNotFoundException;
import com.example.StudentManagementSystem.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository repo;
    private final PasswordEncoder encoder;

    public StudentService(StudentRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    @CachePut(value="students", key="#result.id")
//    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(Student student){
    	student.setPassword(encoder.encode(student.getPassword()));
        return repo.save(student);
    }

    @Cacheable(value="students", key="#id")
    @PostAuthorize("returnObject.name == authentication.name")
    public Student findStudentById(int id){
        return repo.findById(id).orElseThrow(()-> 
        					new StudentNotFoundException("Student with id " + id + " does not exist"));
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Page<Student> findAllStudents(Pageable pageable){
        return repo.findAll(pageable);
    }

    @CachePut(value="students", key="#id")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public Student updateStudent(int id,Student s){

        Student student = repo.findById(id).orElseThrow();

        student.setName(s.getName());
        student.setEmail(s.getEmail());
        student.setCourse(s.getCourse());
        student.setMarks(s.getMarks());

        return repo.save(student);
    }

    @CacheEvict(value="students", key="#id")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(int id){
        repo.deleteById(id);
    }
}
