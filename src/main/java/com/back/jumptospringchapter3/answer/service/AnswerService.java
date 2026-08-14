package com.back.jumptospringchapter3.answer.service;

import com.back.jumptospringchapter3.answer.entity.Answer;
import com.back.jumptospringchapter3.answer.repository.AnswerRepository;
import com.back.jumptospringchapter3.question.entity.Question;
import com.back.jumptospringchapter3.user.entity.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void answerSave(Question question, String content, SiteUser author) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setContent(content);
        answer.setAuthor(author);
        answer.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

}
