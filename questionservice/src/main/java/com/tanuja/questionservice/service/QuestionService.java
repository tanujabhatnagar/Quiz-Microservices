package com.tanuja.questionservice.service;


import com.tanuja.questionservice.dao.QuestionDao;
import com.tanuja.questionservice.model.Question;
import com.tanuja.questionservice.model.QuestionWrapper;
import com.tanuja.questionservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
        try {
        return new ResponseEntity<>(questionDao.findQuestionsByCategoryIgnoreCase(category),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        System.out.println("Controller "+question.toString());
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return  new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
        }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numQuestions) {
        List<Integer> questionList=questionDao.findQuestionsByCategoryIgnoreCase(category,numQuestions);

        return new ResponseEntity<>(questionList, HttpStatus.OK);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
        List<QuestionWrapper> questionWrappers=new ArrayList<>();
        List<Question> questions=new ArrayList<>();

        for(Integer id:questionIds)
        {
            questions.add(questionDao.findById(id).get());
        }
        for(Question question: questions)
        {
            QuestionWrapper wrapper=new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestionTitle(question.getQuestionTitle());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            System.out.println(wrapper);
            questionWrappers.add(wrapper);
        }

        return new ResponseEntity<>(questionWrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        //Optional<Quiz> quiz = quizDao.findById(id);
        List<Question> questions=new ArrayList<>();
        for(Response response:responses){
        questions.add(questionDao.findById(response.getId()).get());
        }


        // Map questionId -> correctAnswer
        Map<Integer, String> rightAnswerMap = questions.stream()
                .collect(Collectors.toMap(Question::getId, Question::getRightAnswer));

        long correct = responses.stream()
                .filter(response -> {
                    String correctAnswer = rightAnswerMap.get(response.getId());
                    return correctAnswer != null && correctAnswer.equals(response.getResponse());
                })
                .count();

        return new ResponseEntity<>((int) correct, HttpStatus.OK);
    }
}
