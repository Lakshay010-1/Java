package org.program.Quiz.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserResponse {

    private Integer id;
    private String answer;

}
