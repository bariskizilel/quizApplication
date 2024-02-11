package com.baris.quizApplication.service;

import com.baris.quizApplication.dto.CreateQuizDto;
import com.baris.quizApplication.model.Question;
import com.baris.quizApplication.model.QuestionWrapper;
import com.baris.quizApplication.model.Quiz;
import com.baris.quizApplication.model.Response;
import com.baris.quizApplication.repository.QuestionRepository;
import com.baris.quizApplication.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;





    public ResponseEntity<String> createQuiz(CreateQuizDto createQuizDto){

        List<Question> questions = questionRepository.findRandomQuestionsByCategory(createQuizDto.getCategory(), createQuizDto.getNumQ());

        Quiz quiz = new Quiz();
        quiz.setTitle(createQuizDto.getTitle());
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return new  ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;

        for(Response response : responses){
            if(response.getChoice().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
