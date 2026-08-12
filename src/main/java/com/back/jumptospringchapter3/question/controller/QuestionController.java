package com.back.jumptospringchapter3.question.controller;

import com.back.jumptospringchapter3.answer.dto.AnswerForm;
import com.back.jumptospringchapter3.question.dto.QuestionForm;
import com.back.jumptospringchapter3.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String showQuestionList(Model model) {
        model.addAttribute("questionList", this.questionService.getList());
        return "question_list";
    }

    @GetMapping("/detail/{id}")
    public String showQuestionDetail(Model model, @PathVariable Integer id, AnswerForm answerForm) {
        model.addAttribute("question", this.questionService.getQuestion(id));
        return "question_detail";
    }

    @GetMapping("/create")
    public String showQuestionCreate(QuestionForm questionForm) {
        return "question_form";
    }

//    @PostMapping("/create")
//    public String questionCreate(@RequestParam(value = "subject") String subject,
//                                 @RequestParam(value = "content") String content) {
//        여기서 저장하고
//        return "redirect:/question/list";  해도 되지만
//    }

    //form으로 받으면 자동으로 검증도 되면서 같은 속성이 바인딩 된다.
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.saveQuestion(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
