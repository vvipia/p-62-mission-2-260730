package com.back.jumptospringchapter3.answer.controller;

import com.back.jumptospringchapter3.answer.dto.AnswerForm;
import com.back.jumptospringchapter3.answer.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/question/detail/{id}")
    public String answerCreate(@PathVariable Integer id,
                               @Valid AnswerForm answerForm,
                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "question_detail";
        }
        this.answerService.answerSave(answerForm.getSubject(), answerForm.getContent());
        return "question_detail";
    }
}
