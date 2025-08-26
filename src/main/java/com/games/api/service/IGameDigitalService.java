package com.games.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.games.api.dto.DigitalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;

public interface IGameDigitalService {
    List<DigitalGameDTO> findAll();
    DigitalGameDTO findById(Long id);
    DigitalGameDTO save(DigitalGameDTO dto);
    DigitalGameDTO update(Long id, DigitalGameDTO dto);
    void delete(Long id);
    Page<DigitalGameDTO> search(GameFilterDTO filter, Pageable pageable);
}
