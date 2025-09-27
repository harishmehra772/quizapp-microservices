package com.learning.quizapp.controllers;

import com.learning.quizapp.model.Question;
import com.learning.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    private QuestionService questionsService;

    @GetMapping("questionsList")
    public List<Question> questions(){
        return this.questionsService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> questionsByCategory(@PathVariable String category){
        return this.questionsService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
        return this.questionsService.addQuestion(question);
    }
}
