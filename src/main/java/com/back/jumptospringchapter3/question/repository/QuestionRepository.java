package com.back.jumptospringchapter3.question.repository;

import com.back.jumptospringchapter3.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
