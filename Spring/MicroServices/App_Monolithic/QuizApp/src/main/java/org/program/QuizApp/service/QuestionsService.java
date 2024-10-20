package org.program.QuizApp.service;
import org.program.QuizApp.model.Questions;
import org.program.QuizApp.repo.QuestionsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
}
