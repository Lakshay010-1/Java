package org.program.QuizApp.repo;
import org.program.QuizApp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionsDao extends JpaRepository<Questions,Integer> {
    List<Questions> findByCategory(String Category);

    @Query(value="select * from questions q where q.category= :category  ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
