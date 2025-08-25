package com.games.api.service;

import com.games.api.dto.ConsoleDTO;
import java.util.List;

public interface IConsoleService {
    List<ConsoleDTO> findAll();
    ConsoleDTO findById(Long id);
    ConsoleDTO save(ConsoleDTO dto);
    ConsoleDTO update(Long id, ConsoleDTO dto);
    void delete(Long id);
}

