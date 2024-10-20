package org.program.Quiz.controller;
import org.program.Quiz.model.QuestionWrapper;
import org.program.Quiz.model.UserResponse;
import org.program.Quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @GetMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String quizName){
        return quizService.createQuiz(category,numQ,quizName );
    }

    @PostMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("id") int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id,@RequestBody List<UserResponse> userResponses){
        return quizService.calculateResult(id,userResponses);
    }


}
