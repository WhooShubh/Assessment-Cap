package com.example.StudentManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentManagementSystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	Student findByName(String name);
}
