package com.tanuja.questionservice.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @JsonProperty("option1")
    private String option1;

    @JsonProperty("option2")
    private String option2;

    @JsonProperty("option3")
    private String option3;

    @JsonProperty("option4")
    private String option4;

    @JsonProperty("question_title")
    private String questionTitle;

    @JsonProperty("right_answer")
    private String rightAnswer;

    @JsonProperty("difficultylevel")
    private String difficultylevel;

    @JsonProperty("category")
    private String category;


    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", questionTitle='" + questionTitle + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                ", difficultylevel='" + difficultylevel + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
