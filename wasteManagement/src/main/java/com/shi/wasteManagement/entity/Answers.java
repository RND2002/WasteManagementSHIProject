package com.shi.wasteManagement.entity;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Answers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String answer;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private QuestionEntity question;

    public Answers(){

    }

    public Answers(long id, String answer, QuestionEntity question) {
        this.id = id;
        this.answer = answer;
        this.question = question;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public QuestionEntity getQuestion() {
        return question;
    }

    public void setQuestion(QuestionEntity question) {
        this.question = question;
    }
}
