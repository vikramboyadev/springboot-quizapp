package com.telusko.quitzapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.quitzapp.model.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{

List<Question>	findQuestionsByCategory(String category);
List<Question> findQuestionsByDifficultyLevel(String difficultyLevel);
@Query(value="select * from question q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
List<Question> findRandomQuestionsByCategory(String category, int numQ);


}
