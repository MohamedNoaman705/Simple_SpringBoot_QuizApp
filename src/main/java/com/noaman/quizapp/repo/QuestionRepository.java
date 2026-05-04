package com.noaman.quizapp.repo;

import com.noaman.quizapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategoryNameIgnoreCase(String name);

    @Query(value = "SELECT q.* FROM question q JOIN category c ON q.category_id = c.id WHERE c.name = :category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
