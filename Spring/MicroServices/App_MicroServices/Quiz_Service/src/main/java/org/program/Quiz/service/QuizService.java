package org.program.Quiz.service;
import org.program.Quiz.feign.QuizFeignInterface;
import org.program.Quiz.model.QuestionWrapper;
import org.program.Quiz.model.Quiz;
import org.program.Quiz.model.UserResponse;
import org.program.Quiz.repo.QuizDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuizFeignInterface quizFeign;

    public ResponseEntity<String> createQuiz(String category, int numQ, String quizName) {
        List<Integer> questionsID=quizFeign.getQuestionsIDForQuiz(category,numQ).getBody();
        Quiz quiz=new Quiz();
        quiz.setQuestionsID(questionsID);
        quiz.setQuizName(quizName);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }


    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Integer> DBquestionsID=quiz.get().getQuestionsID();
        return quizFeign.getQuestionsForQuiz(DBquestionsID);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<UserResponse> userResponses) {
        return quizFeign.calculateScore(userResponses);
    }
}
