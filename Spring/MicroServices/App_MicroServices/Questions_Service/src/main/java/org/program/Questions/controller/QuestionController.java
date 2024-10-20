package org.program.Questions.controller;
import org.program.Questions.model.QuestionWrapper;
import org.program.Questions.model.Questions;
import org.program.Questions.model.UserResponse;
import org.program.Questions.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionsService service;
    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public List<Questions> getQuestions(){
        System.out.println(environment.getProperty("local.server.port"));
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

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsIDForQuiz(@RequestParam String category,@RequestParam Integer numQ){
        return service.getQuestionsIDForQuiz(category,numQ);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(@RequestBody List<Integer> questionsID){
        return service.getQuestionsFromQid(questionsID);
    }

    @PostMapping("calculateScore")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<UserResponse> userResponses){
        return service.getScore(userResponses);
    }


}

