package com.noaman.quizapp.service;

import com.noaman.quizapp.model.AnswerDto;
import com.noaman.quizapp.model.Question;
import com.noaman.quizapp.model.QuestionDto;
import com.noaman.quizapp.model.Quiz;
import com.noaman.quizapp.repo.QuestionRepository;
import com.noaman.quizapp.repo.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizService(QuizRepository quizRepository, QuestionRepository questionRepository){
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        try {
            List<Question> questions = questionRepository.findRandomQuestionByCategory(category, numQ);

            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizRepository.save(quiz);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception ex){
            return new ResponseEntity<>("failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<QuestionDto>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionDto> questionDtos = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionDto dto = new QuestionDto(q.getId(), q.getCategory(),
                    q.getQuestionTitle(), q.getOption1(),
                    q.getOption2(), q.getOption3());

            questionDtos.add(dto);
        }
        return new ResponseEntity<>(questionDtos, HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(int quizId, List<AnswerDto> answerDto){
        Quiz quiz = quizRepository.findById(quizId).get();
        int i = 0;
        int score = 0;
        for(Question q : quiz.getQuestions()){
            if(q.getRightAnswer().equals(answerDto.get(i).getAnswer())){
                score++;
            }
            i++;
        }
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
