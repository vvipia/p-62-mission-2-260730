package com.back.jumptospringchapter3;

import com.back.jumptospringchapter3.question.entity.Question;
import com.back.jumptospringchapter3.question.repository.QuestionRepository;
import com.back.jumptospringchapter3.question.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class JumpToSpringChapter3ApplicationTests {
    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.saveQuestion(subject, content);
        }

    }
}
