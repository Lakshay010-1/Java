package org.program.Quiz.feign;
import org.program.Quiz.model.QuestionWrapper;
import org.program.Quiz.model.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTIONS-SERVICE")
public interface QuizFeignInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestionsIDForQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsForQuiz(@RequestBody List<Integer> questionsID);

    @PostMapping("question/calculateScore")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<UserResponse> userResponses);

}
