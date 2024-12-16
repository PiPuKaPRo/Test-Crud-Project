package com.example.project.api;

import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/human")
public interface HumanController {

    @GetMapping("/{id}")
    ResponseEntity<Optional<Human>> getHuman(@PathVariable("id") Integer id);

    @PutMapping()
    ResponseEntity<HumanDto> update(@RequestBody HumanDto humanDto);

    @PostMapping()
    ResponseEntity<Human> register(@RequestBody HumanDto humanDto);

    @DeleteMapping("/{id}")
    void deleteHuman(@PathVariable("id") int id);
}
