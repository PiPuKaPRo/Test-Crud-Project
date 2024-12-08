package com.example.project.api.controller;

import com.example.project.api.HumanController;
import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import com.example.project.repository.HumanRepository;
import com.example.project.service.HumanServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class HumanControllerImpl implements HumanController {

    private final HumanServiceImpl humanService;

    private final HumanRepository humanRepository;

    @Override
    public ResponseEntity<HumanDto> getHuman(int id) {
        HumanDto humanDto = new HumanDto();

        var human = humanRepository.findById(id);

        humanDto.setId(human.getId());
        humanDto.setLogin(human.getLogin());
        humanDto.setPhoneNumber(human.getPhoneNumber());

        return ResponseEntity.ok(humanDto);
    }

    @Override
    public ResponseEntity<HumanDto> update(HttpServletResponse response, HumanDto humanDto) {
        humanService.update(humanDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Human> register(HttpServletResponse response, HumanDto humanDto) {
        return ResponseEntity.ok(humanService.save(humanDto));
    }

    @Override
    public void deleteHuman(int id) {
        humanService.delete(id);
    }
}
