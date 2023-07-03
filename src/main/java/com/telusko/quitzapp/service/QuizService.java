package com.telusko.quitzapp.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.quitzapp.dao.QuestionDao;
import com.telusko.quitzapp.dao.QuizDao;
import com.telusko.quitzapp.model.Question;
import com.telusko.quitzapp.model.QuestionWrapper;
import com.telusko.quitzapp.model.Quiz;
import com.telusko.quitzapp.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {

		List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizDao.save(quiz);

		return new ResponseEntity<>("Success Bhai", HttpStatus.CREATED);

	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

		java.util.Optional<Quiz> quiz = quizDao.findById(id);
		List<Question> questionsfromDB = quiz.get().getQuestions();
		List<QuestionWrapper> questionsForUser = new ArrayList<>();

		for (Question q : questionsfromDB) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(),
					q.getOption3(), q.getOption4());
			questionsForUser.add(qw);
		}
		return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> response) {
		Quiz quiz = quizDao.findById(id).get();
		List<Question> questions = quiz.getQuestions();
		int right = 0;
		int i = 0;

		for (Response response1 : response) {
			if (response1.getResponse().equals(questions.get(i).getRightAnwer()))
				right++;
			i++;
		}

		return new ResponseEntity<>(right, HttpStatus.OK);

	}
}
