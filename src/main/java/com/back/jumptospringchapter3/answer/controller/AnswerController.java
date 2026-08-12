package com.back.jumptospringchapter3.answer.controller;

import com.back.jumptospringchapter3.answer.dto.AnswerForm;
import com.back.jumptospringchapter3.answer.service.AnswerService;
import com.back.jumptospringchapter3.question.entity.Question;
import com.back.jumptospringchapter3.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/create/{id}")
    public String answerCreate(@PathVariable Integer id,
                               @Valid AnswerForm answerForm,
                               BindingResult bindingResult, Model model) {
        Question question = this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.answerSave(question, answerForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }
}
