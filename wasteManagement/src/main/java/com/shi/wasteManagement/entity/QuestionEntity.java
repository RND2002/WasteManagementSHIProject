package com.shi.wasteManagement.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String question;

    private String category;

    private String image;
    @OneToMany(mappedBy = "question")
    private List<Answers> answers=new ArrayList<>();

    public QuestionEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answers> answers) {
        this.answers = answers;
    }

    public QuestionEntity(long id, String question, String category, String image, List<Answers> answers) {
        this.id = id;
        this.question = question;
        this.category = category;
        this.image = image;
        this.answers = answers;
    }
}

