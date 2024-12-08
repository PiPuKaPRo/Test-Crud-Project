package com.example.project.repository;

import com.example.project.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HumanRepository extends JpaRepository<Human, Integer> {

    Human findById(int id);

    Human findByLogin(String login);

}
