package com.example.project.api.controller;

import com.example.project.api.HumanController;
import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import com.example.project.repository.HumanRepository;
import com.example.project.service.HumanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class HumanControllerImpl implements HumanController {

    private final HumanService humanService;

    public ResponseEntity<Optional<Human>> getHuman(Integer id) {
        return ResponseEntity.ok(humanService.findById(id));
    }

    @Override
    public ResponseEntity<HumanDto> update(HumanDto humanDto) {
        humanService.update(humanDto);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Human> register(HumanDto humanDto) {
        return ResponseEntity.ok(humanService.save(humanDto));
    }

    @Override
    public void deleteHuman(int id) {
        humanService.delete(id);
    }
}
