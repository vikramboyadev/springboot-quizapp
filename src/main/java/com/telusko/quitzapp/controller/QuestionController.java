package com.telusko.quitzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quitzapp.model.Question;
import com.telusko.quitzapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions() {
		return(questionService.getAllQuestions());
	}
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionByCategory(@PathVariable String category){
	
		return questionService.getQuestionsByCategory(category);
	}
	
	
	@GetMapping("category/{difficultyLevel}")
	public List<Question> getQuestionsByDifficultyLevel(@PathVariable String difficultyLevel){
		return  questionService.getQuestionsByDifficultyLevel(difficultyLevel);
	}
	
	@PostMapping("addQuestions")
	public ResponseEntity<String> addQuestions(@RequestBody Question question) {
		return questionService.addQuestions(question);	
	}
	
	
	
	
	
}
