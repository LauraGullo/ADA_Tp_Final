package com.example.concept.model.repositories;

import com.example.concept.model.entities.Answers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AnswersRepository extends JpaRepository<Answers, Long> {
    public List<Answers> findAllByIdAnswersAndIdQuestion (Long idAnswers, Long idQuestion);

}
