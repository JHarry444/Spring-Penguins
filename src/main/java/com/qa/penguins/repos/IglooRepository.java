package com.qa.penguins.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.penguins.domain.Igloo;

@Repository
public interface IglooRepository extends JpaRepository<Igloo, Long> {

}
