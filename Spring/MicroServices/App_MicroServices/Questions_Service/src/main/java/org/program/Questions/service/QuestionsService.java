package org.program.Questions.service;
import org.program.Questions.model.QuestionWrapper;
import org.program.Questions.model.Questions;
import org.program.Questions.model.UserResponse;
import org.program.Questions.repo.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class QuestionsService {
    @Autowired
    QuestionsDao dao;

    public List<Questions> getQuestions() {
        return  dao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        return dao.findByCategory(category);
    }

    public ResponseEntity<Questions> addQuestion(Questions q) {
        try{
            return new ResponseEntity<>(dao.save(q), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Integer>> getQuestionsIDForQuiz(String category, Integer numQ) {
        return new ResponseEntity<>(dao.findRandomQuestionsByCategory(category,numQ),HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromQid(List<Integer> questionsID) {
        List<QuestionWrapper> questions=new ArrayList<>();
        for(int id:questionsID){
            Questions question=dao.findById(id).orElse(new Questions());
            questions.add(new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4()));
        }
        return new ResponseEntity<>(questions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<UserResponse> userResponses) {
        int score=0;
        for(UserResponse response:userResponses){
            Questions question=dao.findById(response.getId()).orElse(new Questions());
            if(question.getRightAnswer().equals(response.getAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}

