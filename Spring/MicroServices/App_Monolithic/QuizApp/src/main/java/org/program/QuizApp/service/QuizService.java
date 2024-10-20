package org.program.QuizApp.service;
import org.program.QuizApp.model.QuestionWrapper;
import org.program.QuizApp.model.Questions;
import org.program.QuizApp.model.Quiz;
import org.program.QuizApp.model.UserResponse;
import org.program.QuizApp.repo.QuestionsDao;
import org.program.QuizApp.repo.QuizDao;
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
    QuestionsDao questionsDao;

    public ResponseEntity<List<Questions>> createQuiz(String category, int numQ, String quizName) {
        Quiz quiz=new Quiz();
        List<Questions> list=questionsDao.findRandomQuestionsByCategory(category,numQ);
        quiz.setQuestions(list);
        quiz.setQuizName(quizName);
        quizDao.save(quiz);
        return new ResponseEntity<>(list,HttpStatus.CREATED);
    }


    public List<QuestionWrapper> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizDao.findById(id);
        List<Questions> DBquestions=quiz.get().getQuestions();
        List<QuestionWrapper> UserQuestions=new ArrayList<>();
        for(Questions q:DBquestions){
            UserQuestions.add(new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4()));
        }
        return UserQuestions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<UserResponse> userResponses) {
        Optional<Quiz> quiz=quizDao.findById(id);
        List<Questions> questions=quiz.get().getQuestions();
        int score=0;
        for(Questions question:questions){
            for(UserResponse response:userResponses){
                if(question.getId()==response.getId() && question.getRightAnswer().equals(response.getAnswer())){
                    score++;
                    break;
                }
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
