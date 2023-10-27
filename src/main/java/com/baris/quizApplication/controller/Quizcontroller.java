package com.baris.quizApplication.controller;

import com.baris.quizApplication.dto.CreateQuizDto;
import com.baris.quizApplication.model.QuestionWrapper;
import com.baris.quizApplication.model.Quiz;
import com.baris.quizApplication.model.Response;
import com.baris.quizApplication.repository.QuizRepository;
import com.baris.quizApplication.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class Quizcontroller {private final QuizService quizService;
    private final QuizRepository quizRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDto createQuizDto){
        return quizService.createQuiz(createQuizDto);
    }

    @GetMapping
    public ResponseEntity<List<Quiz>> getAllQuiz(){
        List<Quiz> allQuiz = quizRepository.findAll();
        return new ResponseEntity<>(allQuiz, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
