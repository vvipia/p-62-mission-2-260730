package com.back.jumptospringchapter3.answer.controller;

import com.back.jumptospringchapter3.answer.dto.AnswerForm;
import com.back.jumptospringchapter3.answer.service.AnswerService;
import com.back.jumptospringchapter3.question.entity.Question;
import com.back.jumptospringchapter3.question.service.QuestionService;
import com.back.jumptospringchapter3.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String answerCreate(@PathVariable Integer id,
                               @Valid AnswerForm answerForm,
                               BindingResult bindingResult,
                               Model model,
                               Principal principal) {
        Question question = this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "question_detail";
        }
        this.answerService.answerSave(question, answerForm.getContent(), this.userService.getUser(principal.getName()));
        return String.format("redirect:/question/detail/%s", id);
    }
}
