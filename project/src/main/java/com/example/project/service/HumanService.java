package com.example.project.service;

import com.example.project.dto.HumanDto;
import com.example.project.entity.Human;

public interface HumanService {

    Human save(HumanDto humanDto);

    void delete(int id);

    void update(HumanDto humanDto);
}
