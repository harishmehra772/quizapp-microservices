package com.learning.quizapp.controllers;

import com.learning.quizapp.model.Question;
import com.learning.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionsService;

    @GetMapping("questionsList")
    public ResponseEntity<List<Question>> questions(){
        return this.questionsService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> questionsByCategory(@PathVariable String category){
        return this.questionsService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return this.questionsService.addQuestion(question);
    }

    @PutMapping("updateQuestion")
    public ResponseEntity<String> updateQuestion(@RequestBody Question question){
        return this.questionsService.addQuestion(question);
    }

    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id){
        return this.questionsService.deleteQuestion(id);
    }


}
