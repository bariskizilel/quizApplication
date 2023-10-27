package com.baris.quizApplication.service;

import com.baris.quizApplication.model.Question;
import com.baris.quizApplication.repository.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;


    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }


    public ResponseEntity<List<Question>> getAllQuestions() {
        return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
    }

    public void deleteQuestion(Integer id) {
        boolean exists = questionRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("question with id " + id + ", does not exist");
        }
        questionRepository.deleteById(id);
    }

    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        questionRepository.save(question);
        return new ResponseEntity<>("question is added", HttpStatus.CREATED);
    }
}
