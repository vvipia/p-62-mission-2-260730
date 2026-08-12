package com.back.jumptospringchapter3.answer.repository;

import com.back.jumptospringchapter3.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
