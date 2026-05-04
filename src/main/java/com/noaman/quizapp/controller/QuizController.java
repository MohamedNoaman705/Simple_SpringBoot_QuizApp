package com.noaman.quizapp.controller;

import com.noaman.quizapp.model.AnswerDto;
import com.noaman.quizapp.model.QuestionDto;
import com.noaman.quizapp.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    private final QuizService service;

    public QuizController(QuizService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,
                                             @RequestParam int numQ, @RequestParam String title){
        return service.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionDto>> getQuizQuestions(@PathVariable int id){
        return service.getQuizQuestions(id);
    }

    @PostMapping("/submit/{quizId}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable int quizId, @RequestBody List<AnswerDto> answerDtos){
        return service.submitQuiz(quizId, answerDtos);
    }

}
