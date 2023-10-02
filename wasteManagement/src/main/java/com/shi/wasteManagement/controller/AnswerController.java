package com.shi.wasteManagement.controller;

import com.shi.wasteManagement.entity.Answers;
import com.shi.wasteManagement.entity.QuestionEntity;
import com.shi.wasteManagement.service.AnswerService;
import com.shi.wasteManagement.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class AnswerController {
    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;

    @GetMapping("answers/{id}")
    public String goToAnswerPage(Model model,@PathVariable Long id){
        QuestionEntity question=questionService.findByQuestionId(id);


//        Answers answer=new Answers();
//        answer.setQuestion(question);
        //model.addAttribute("id",id);
        model.addAttribute("question",question);
        List<Answers> answers=answerService.getAllAnswerForQuestion(id);
        if(!answers.isEmpty()) {
            model.addAttribute("answers", answers);
        }
        return "Answers";
    }


    @GetMapping("answersForm/{id}")
    public String goToAnswerQuestion(Model model,@PathVariable Long id){
        QuestionEntity question=questionService.findByQuestionId(id);
        model.addAttribute("question",question);
        model.addAttribute("answer",new Answers());
        return "AnswerForm";
    }

    @PostMapping("processAnswer/{id}")
    public String saveAnswer(@ModelAttribute  Answers answer,@PathVariable Long id){


        QuestionEntity question=questionService.findByQuestionId(id);
        answer.setQuestion(question);
        //model.addAttribute("answer",new Answers());
        answerService.addAnswerToRepository(answer);
        //return "redirect:/answers/{id}";

        return "redirect:/";
    }
//    @GetMapping("/answers/{id}")
//    public String getAllAnswers(Model model,@PathVariable Long id){
//        QuestionEntity question=questionService.findByQuestionId(id);
//        long qid=question.getId();
//        List<Answers> answers=answerService.getAllAnswerForQuestion(id);
//        model.addAttribute("answers",answers);
//        return "Answers";
//
//    }


}
