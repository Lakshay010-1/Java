package org.program.Quiz.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String quizName;
    @ElementCollection
    private List<Integer> questionsID;

}
