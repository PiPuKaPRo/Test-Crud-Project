package com.example.project.service;

import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import com.example.project.repository.HumanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class HumanServiceImpl implements HumanService {

    private final HumanRepository humanRepository;

    @Override
    public Human save(HumanDto humanDto) {
        if (humanDto == null || humanDto.getId() == 0) {
            throw new IllegalArgumentException("Invalid registration data");
        }

        if (humanDto.getLogin().equals(humanRepository.findByLogin(humanDto.getLogin()).getLogin())) {
            throw new IllegalArgumentException("Login already exists");
        }

        Human human = new Human();

        human.setId(humanDto.getId());
        human.setLogin(humanDto.getLogin());
        human.setPhoneNumber(humanDto.getPhoneNumber());

        return humanRepository.save(human);
    }

    @Override
    public void delete(int id) {
        humanRepository.delete(humanRepository.findById(id));
    }

    @Override
    public void update(HumanDto humanDto) {
        if (humanDto == null) {
            throw new IllegalArgumentException("Invalid data");
        }


        Human human = humanRepository.findById(humanDto.getId());
        if (humanDto.getLogin() != null) {
            human.setLogin(humanDto.getLogin());
        }

        if (humanDto.getPhoneNumber() != null) {
            human.setPhoneNumber(humanDto.getPhoneNumber());
        }

        humanRepository.save(human);
    }
}
