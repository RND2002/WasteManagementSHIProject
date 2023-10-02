package com.shi.wasteManagement.service;

import com.shi.wasteManagement.entity.Answers;
import com.shi.wasteManagement.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswersRepository answersRepository;

    public String saveAnswers(Answers answer){
        answersRepository.save(answer);
        return "done";
    }

    public void addAnswerToRepository(Answers answer) {
        answersRepository.save(answer);
    }

    public List<Answers> getAllAnswerForQuestion(Long id){
        return answersRepository.findAllById(Collections.singleton(id));
    }


}
