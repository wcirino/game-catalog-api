package com.games.api.service.impl;

import com.games.api.dto.ConsoleDTO;
import com.games.api.entity.Console;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.ConsoleRepository;
import com.games.api.service.IConsoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsoleServiceImpl implements IConsoleService {

    private final ConsoleRepository repository;

    @Override
    public List<ConsoleDTO> findAll() {
        log.info("Fetching all consoles...");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public ConsoleDTO findById(Long id) {
        log.info("Fetching console by id: {}", id);
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Console not found with id: " + id));
    }

    @Override
    public ConsoleDTO save(ConsoleDTO dto) {
        log.info("Saving new console: {}", dto.getName());
        Console saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public ConsoleDTO update(Long id, ConsoleDTO dto) {
        log.info("Updating console with id: {}", id);
        Console existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Console not found with id: " + id));
        existing.setName(dto.getName());
        existing.setManufacturer(dto.getManufacturer());
        existing.setReleaseYear(dto.getReleaseYear());
        existing.setActive(dto.getActive());
        return toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting console with id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Console not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private ConsoleDTO toDTO(Console entity) {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setManufacturer(entity.getManufacturer());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setActive(entity.getActive());
        return dto;
    }

    private Console toEntity(ConsoleDTO dto) {
        Console entity = new Console();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setManufacturer(dto.getManufacturer());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setActive(dto.getActive());
        return entity;
    }
}
