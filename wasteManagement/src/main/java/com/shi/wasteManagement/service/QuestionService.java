package com.shi.wasteManagement.service;

import com.shi.wasteManagement.entity.QuestionEntity;
import com.shi.wasteManagement.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public String addQuestionToRepository(QuestionEntity question)  {


        questionRepository.save(question);
        return "succesfully question added";
    }

    public List<QuestionEntity> getQuestionFromRepository(){
        return questionRepository.findAll();

    }

    public QuestionEntity findByQuestionId(Long id) {
       QuestionEntity question=questionRepository.getById(id);
       return question;
    }
}
