package com.learning.quizapp.services;

import com.learning.quizapp.dao.QuestionDao;
import com.learning.quizapp.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(this.questionDao.findAll(),HttpStatus.OK);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(this.questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
            this.questionDao.save(question);
            return new ResponseEntity<>("Success",HttpStatus.CREATED);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>("Error",HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try{
            this.questionDao.deleteById(id);
            return new ResponseEntity<>("Success",HttpStatus.OK);
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new ResponseEntity<>("NOT FOUND",HttpStatus.NO_CONTENT);
    }
}
