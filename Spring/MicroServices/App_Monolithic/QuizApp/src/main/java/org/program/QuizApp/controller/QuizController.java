package org.program.QuizApp.controller;
import org.program.QuizApp.model.QuestionWrapper;
import org.program.QuizApp.model.Questions;
import org.program.QuizApp.model.UserResponse;
import org.program.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<List<Questions>> createQuiz(@RequestParam String category,@RequestParam int numQ,@RequestParam String quizName){
        return quizService.createQuiz(category,numQ,quizName);
    }

    @GetMapping("/get/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable("id") int id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable("id") Integer id,@RequestBody List<UserResponse> userResponses){
        return quizService.calculateResult(id,userResponses);
    }


}
