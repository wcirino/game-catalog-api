package com.games.api.service.impl;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.entity.PhysicalGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.PhysicalGameRepository;
import com.games.api.service.IGamePhysicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GamePhysicalServiceImpl implements IGamePhysicalService {

    private final PhysicalGameRepository repository;

    @Override
    public List<PhysicalGameDTO> findAll() {
        log.info("Fetching all physical games...");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public PhysicalGameDTO findById(Long id) {
        log.info("Fetching physical game by id: {}", id);
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Physical game not found with id: " + id));
    }

    @Override
    public PhysicalGameDTO save(PhysicalGameDTO dto) {
        log.info("Saving new physical game: {}", dto.getTitle());
        PhysicalGame saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public PhysicalGameDTO update(Long id, PhysicalGameDTO dto) {
        log.info("Updating physical game with id: {}", id);
        PhysicalGame existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Physical game not found with id: " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setGenre(dto.getGenre());
        existing.setReleaseYear(dto.getReleaseYear());
        existing.setPlatform(dto.getPlatform());
        existing.setProductionStudio(dto.getProductionStudio());
        existing.setPrice(dto.getPrice());
        existing.setActive(dto.getActive());
        existing.setMediaType(dto.getMediaType());
        existing.setConditionStatus(dto.getConditionStatus());
        existing.setManualLanguage(dto.getManualLanguage());
        existing.setHasBox(dto.getHasBox());
        existing.setConsoleId(dto.getConsoleId());

        return toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting physical game with id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Physical game not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private PhysicalGameDTO toDTO(PhysicalGame entity) {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setGenre(entity.getGenre());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setPlatform(entity.getPlatform());
        dto.setProductionStudio(entity.getProductionStudio());
        dto.setPrice(entity.getPrice());
        dto.setActive(entity.getActive());
        dto.setMediaType(entity.getMediaType());
        dto.setConditionStatus(entity.getConditionStatus());
        dto.setManualLanguage(entity.getManualLanguage());
        dto.setHasBox(entity.getHasBox());
        dto.setConsoleId(entity.getConsoleId());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private PhysicalGame toEntity(PhysicalGameDTO dto) {
        PhysicalGame entity = new PhysicalGame();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setGenre(dto.getGenre());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setPlatform(dto.getPlatform());
        entity.setProductionStudio(dto.getProductionStudio());
        entity.setPrice(dto.getPrice());
        entity.setActive(dto.getActive());
        entity.setMediaType(dto.getMediaType());
        entity.setConditionStatus(dto.getConditionStatus());
        entity.setManualLanguage(dto.getManualLanguage());
        entity.setHasBox(dto.getHasBox());
        entity.setConsoleId(dto.getConsoleId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
