package com.tanuja.questionservice.dao;

import com.tanuja.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    @Query("SELECT q.id FROM Question q WHERE q.category  Ilike  %:category%")
    List<Question> findQuestionsByCategoryIgnoreCase(@Param("category") String category);

    @Query("SELECT q.id FROM Question q WHERE q.category  Ilike  %:category% ORDER BY RANDOM() LIMIT :numQuestion")
    List<Integer> findQuestionsByCategoryIgnoreCase(String category, Integer numQuestion);
}
