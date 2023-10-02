package com.shi.wasteManagement.controller;

import com.shi.wasteManagement.entity.Answers;
import com.shi.wasteManagement.entity.QuestionEntity;
import com.shi.wasteManagement.service.AnswerService;
import com.shi.wasteManagement.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ThymeleafController {

    QuestionService questionService;

    public ThymeleafController(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Autowired
    AnswerService answerService;
    @GetMapping("/")
    public String goToDashboard(Model model){
        List<QuestionEntity> questions =questionService.getQuestionFromRepository();
        model.addAttribute("questions",questions);

        return "Dashboard";
    }
    @GetMapping("marketPlace")
    public String goToMarketPlace(){
        return "MarketPlace";
    }

    @GetMapping("about")
    public String goToAboutPage(){
        return "About";
    }
    @GetMapping("addQuestion")
    public String goToForm(Model model){
        model.addAttribute("question",new QuestionEntity());
        return "Form";
    }

    @PostMapping("processQuestion")
    public String addQuestionToRepository(@ModelAttribute QuestionEntity question, @RequestParam("file") MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            question.setImage(file.getOriginalFilename());
            System.out.println(new ClassPathResource("").getFile().getAbsolutePath()+" fuck you");
            System.out.println(new ClassPathResource("").getFile().getAbsolutePath()+" fuck you");
            File saveFile=new ClassPathResource("static/image/").getFile();
            Path path= Paths.get((saveFile.getAbsolutePath()+File.separator+file.getOriginalFilename()));
            Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        }
        questionService.addQuestionToRepository(question);
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
