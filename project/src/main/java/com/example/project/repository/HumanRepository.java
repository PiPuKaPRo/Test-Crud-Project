package com.example.project.repository;

import com.example.project.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface HumanRepository extends JpaRepository<Human, Integer> {

    Human findByLogin(String login);

}
