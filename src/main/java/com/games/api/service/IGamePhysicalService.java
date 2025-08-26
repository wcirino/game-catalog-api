package com.games.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;

public interface IGamePhysicalService {
    List<PhysicalGameDTO> findAll();
    PhysicalGameDTO findById(Long id);
    PhysicalGameDTO save(PhysicalGameDTO dto);
    PhysicalGameDTO update(Long id, PhysicalGameDTO dto);
    void delete(Long id);
    Page<PhysicalGameDTO> search(GameFilterDTO filter, Pageable pageable);
}
