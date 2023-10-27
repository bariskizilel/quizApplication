package com.baris.quizApplication.repository;

import com.baris.quizApplication.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
