package com.tanuja.quiz_service.service;

import com.tanuja.quiz_service.dao.QuizDao;
import com.tanuja.quiz_service.feign.QuizInterface;
import com.tanuja.quiz_service.model.QuestionWrapper;
import com.tanuja.quiz_service.model.Quiz;
import com.tanuja.quiz_service.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizInterface quizInterface;

    @Autowired
    QuizDao quizDao;


    public ResponseEntity<String> createQuiz(String category,Integer numQuestion, String title) {

        List<Integer> questionId=quizInterface.getQuestionsForQuiz(category,numQuestion).getBody();
        Quiz quiz=new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionId);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);

     }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Quiz quiz=quizDao.findById(id).get();
         List<Integer> questionIds=quiz.getQuestionIds();
         quizInterface.getQuestionsFromId(questionIds);
         ResponseEntity<List<QuestionWrapper>> questions=quizInterface.getQuestionsFromId(questionIds);
         return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response>  response) {
        ResponseEntity<Integer> score=quizInterface.getScore(response);
    return score;
    }

}
