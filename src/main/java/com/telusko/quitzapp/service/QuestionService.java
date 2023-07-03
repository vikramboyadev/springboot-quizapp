package com.telusko.quitzapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quitzapp.dao.QuestionDao;
import com.telusko.quitzapp.model.Question;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
	}
catch(Exception e) {
	e.printStackTrace();
	}
return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestions(Question question) {
		questionDao.save(question);
		return new ResponseEntity<>("Success",HttpStatus.CREATED);
		
	}

	public List<Question> getQuestionsByCategory(String category) {
		return questionDao.findQuestionsByCategory(category);
	}
	
	public List<Question> getQuestionsByDifficultyLevel(String difficultyLevel){
		return questionDao.findQuestionsByDifficultyLevel(difficultyLevel);
	}

}
