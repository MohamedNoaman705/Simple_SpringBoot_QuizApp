package com.noaman.quizapp.service;

import com.noaman.quizapp.model.Question;
import com.noaman.quizapp.repo.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    private QuestionRepository repo;

    public QuestionService(QuestionRepository repo){
        this.repo = repo;
    }

    public ResponseEntity<List<Question>> getAllQuestions(){
        try{
            return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
            return new ResponseEntity<>(repo.findByCategoryNameIgnoreCase(category), HttpStatus.FOUND);
        }catch (Exception ex){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> addQuestion(Question question) {
        repo.save(question);
        try {
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>("Faild", HttpStatus.BAD_REQUEST);
        }
    }

}
