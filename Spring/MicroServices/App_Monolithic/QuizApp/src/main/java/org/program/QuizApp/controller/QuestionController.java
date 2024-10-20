package org.program.QuizApp.controller;
import org.program.QuizApp.model.Questions;
import org.program.QuizApp.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionsService service;

    @GetMapping("allQuestions")
    public List<Questions> getQuestions(){
        return service.getQuestions();
    }

    @GetMapping("category/{category}")
    public List<Questions> getQuestionsByCategory(@PathVariable("category") String category){
        return service.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<Questions> addQuestion(@RequestBody Questions questions){
        return service.addQuestion(questions);
    }
}
