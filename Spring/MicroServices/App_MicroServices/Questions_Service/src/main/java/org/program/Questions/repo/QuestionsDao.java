package org.program.Questions.repo;
import org.program.Questions.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String Category);

    @Query(value="select q.id from questions q where q.category= :category  ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);


}
