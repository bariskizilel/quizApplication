package com.baris.quizApplication.controller;

import com.baris.quizApplication.model.Question;
import com.baris.quizApplication.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("question")
public class QuestionController {
    private final QuestionService questionService;


    @GetMapping()
    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return questionService.getAllQuestions();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
    }
}
