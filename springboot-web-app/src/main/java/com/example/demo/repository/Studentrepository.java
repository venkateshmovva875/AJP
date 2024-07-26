package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.student;

public interface Studentrepository extends JpaRepository<student, String>{

	List<student> findAll();
}
