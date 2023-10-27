package com.baris.quizApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateQuizDto {
    String category;
    int numQ;
    String title;
}
