package com.telusko.quitzapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.quitzapp.model.QuestionWrapper;
import com.telusko.quitzapp.model.Response;
import com.telusko.quitzapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuitzController {

	@Autowired
	QuizService quizService;

	@PostMapping("create")
	public ResponseEntity<String> createQuitz(@RequestParam String category, @RequestParam int numQ,
			@RequestParam String title) {

		return quizService.createQuiz(category, numQ, title);

	}

	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getcategorycategoryQuizquestions(@PathVariable Integer id){
		return quizService.getQuizQuestions(id);
	
	}
	
	@PostMapping("submit/{id}")
	
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> response){
		return quizService.calculateResult(id,response);
		
	}
	
	
	
	
	
}
