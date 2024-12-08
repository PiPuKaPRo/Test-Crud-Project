package com.example.project.api;

import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/human")
public interface HumanController {

    @GetMapping("/{id}")
    ResponseEntity<HumanDto> getHuman(@PathVariable("id") int id);

    @PutMapping("/update")
    ResponseEntity<HumanDto> update(HttpServletResponse response, @RequestBody HumanDto humanDto);

    @PostMapping("/create")
    ResponseEntity<Human> register(HttpServletResponse response, @RequestBody HumanDto humanDto);

    @DeleteMapping("/{id}")
    void deleteHuman(@PathVariable("id") int id);
}
