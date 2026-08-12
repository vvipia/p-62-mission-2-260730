package com.back.jumptospringchapter3;

import com.back.jumptospringchapter3.question.entity.Question;
import com.back.jumptospringchapter3.question.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class JumpToSpringChapter3ApplicationTests {
    @Autowired
    QuestionRepository questionRepository;

    @Test
    void test1() {
        Question question = new Question();
        question.setSubject("테스트입니다.");
        question.setContent("테스트입니다.");
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

}
