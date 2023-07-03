package com.telusko.quitzapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.quitzapp.model.Quiz;

public interface QuizDao  extends JpaRepository<Quiz, Integer>{

}
