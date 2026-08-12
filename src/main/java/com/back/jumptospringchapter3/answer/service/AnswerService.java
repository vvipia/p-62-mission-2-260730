package com.back.jumptospringchapter3.answer.service;

import com.back.jumptospringchapter3.answer.entity.Answer;
import com.back.jumptospringchapter3.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void answerSave(String subject, String content) {
        Answer answer = new Answer();
        answer.setSubject(subject);
        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }
}
