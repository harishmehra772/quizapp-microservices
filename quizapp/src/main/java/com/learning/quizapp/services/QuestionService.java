package com.learning.quizapp.services;

import com.learning.quizapp.dao.QuestionDao;
import com.learning.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return this.questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return this.questionDao.findByCategory(category);
    }

    public String addQuestion(Question question){
        this.questionDao.save(question);
        return "Success";
    }
}
