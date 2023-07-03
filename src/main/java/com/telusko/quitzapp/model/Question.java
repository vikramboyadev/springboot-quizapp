package com.telusko.quitzapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String questionTitle;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String rightAnwer;
	private String difficultyLevel;
	private String category;
	
	
	
	
	

}
