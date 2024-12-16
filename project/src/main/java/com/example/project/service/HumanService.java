package com.example.project.service;

import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import com.example.project.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class HumanService {

    private final HumanRepository humanRepository;

    public Human save(HumanDto humanDto) {
        if (humanDto == null || humanDto.id() == null) {
            throw new IllegalArgumentException("Invalid registration data");
        }

        if (humanDto.login().equals(humanRepository.findByLogin(humanDto.login()).getLogin())) {
            throw new IllegalArgumentException("Login already exists");
        }

        Human human = new Human();

        human.setId(humanDto.id());
        human.setLogin(humanDto.login());
        human.setPhoneNumber(humanDto.phoneNumber());

        return humanRepository.save(human);
    }

    public void delete(Integer id) {
        humanRepository.delete(humanRepository.findById(id).get());
    }

    public Optional<Human> findById(Integer id) {
        return humanRepository.findById(id);
    }

    public void update(HumanDto humanDto) {
        if (humanDto == null) {
            throw new IllegalArgumentException("Invalid data");
        }


        Optional<Human> human = humanRepository.findById(humanDto.id());
        if (humanDto.login() != null) {
            human.ifPresent(human1 -> human1.setLogin(humanDto.login()));
        }

        if (humanDto.phoneNumber() != null) {
            human.ifPresent(human1 -> human1.setPhoneNumber(humanDto.phoneNumber()));
        }

        humanRepository.save(human.get());
    }
}
