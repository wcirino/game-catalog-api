package com.games.api.service;

import com.games.api.dto.DigitalGameDTO;
import java.util.List;

public interface IGameDigitalService {
    List<DigitalGameDTO> findAll();
    DigitalGameDTO findById(Long id);
    DigitalGameDTO save(DigitalGameDTO dto);
    DigitalGameDTO update(Long id, DigitalGameDTO dto);
    void delete(Long id);
}
