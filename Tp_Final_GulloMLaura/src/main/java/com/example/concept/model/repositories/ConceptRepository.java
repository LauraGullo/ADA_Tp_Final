package com.example.concept.model.repositories;

import com.example.concept.model.entities.Concept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRepository extends JpaRepository <Concept, Long>  {


}
