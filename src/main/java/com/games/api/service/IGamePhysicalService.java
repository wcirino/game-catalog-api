package com.games.api.service;

import com.games.api.dto.PhysicalGameDTO;
import java.util.List;

public interface IGamePhysicalService {
    List<PhysicalGameDTO> findAll();
    PhysicalGameDTO findById(Long id);
    PhysicalGameDTO save(PhysicalGameDTO dto);
    PhysicalGameDTO update(Long id, PhysicalGameDTO dto);
    void delete(Long id);
}
