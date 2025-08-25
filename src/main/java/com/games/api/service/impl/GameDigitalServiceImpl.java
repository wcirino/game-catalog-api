package com.games.api.service.impl;

import com.games.api.dto.DigitalGameDTO;
import com.games.api.entity.DigitalGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.DigitalGameRepository;
import com.games.api.service.IGameDigitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameDigitalServiceImpl implements IGameDigitalService {

    private final DigitalGameRepository repository;

    @Override
    public List<DigitalGameDTO> findAll() {
        log.info("Fetching all digital games...");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public DigitalGameDTO findById(Long id) {
        log.info("Fetching digital game by id: {}", id);
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Digital game not found with id: " + id));
    }

    @Override
    public DigitalGameDTO save(DigitalGameDTO dto) {
        log.info("Saving new digital game: {}", dto.getTitle());
        DigitalGame saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public DigitalGameDTO update(Long id, DigitalGameDTO dto) {
        log.info("Updating digital game with id: {}", id);
        DigitalGame existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Digital game not found with id: " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setGenre(dto.getGenre());
        existing.setReleaseYear(dto.getReleaseYear());
        existing.setPlatform(dto.getPlatform());
        existing.setProductionStudio(dto.getProductionStudio());
        existing.setPrice(dto.getPrice());
        existing.setActive(dto.getActive());
        existing.setActivationKey(dto.getActivationKey());
        existing.setDigitalStore(dto.getDigitalStore());
        existing.setDownloadSize(dto.getDownloadSize());
        existing.setLicenseExpiration(dto.getLicenseExpiration());
        existing.setConsoleId(dto.getConsoleId());

        return toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting digital game with id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Digital game not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private DigitalGameDTO toDTO(DigitalGame entity) {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setGenre(entity.getGenre());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setPlatform(entity.getPlatform());
        dto.setProductionStudio(entity.getProductionStudio());
        dto.setPrice(entity.getPrice());
        dto.setActive(entity.getActive());
        dto.setActivationKey(entity.getActivationKey());
        dto.setDigitalStore(entity.getDigitalStore());
        dto.setDownloadSize(entity.getDownloadSize());
        dto.setLicenseExpiration(entity.getLicenseExpiration());
        dto.setConsoleId(entity.getConsoleId());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private DigitalGame toEntity(DigitalGameDTO dto) {
        DigitalGame entity = new DigitalGame();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setGenre(dto.getGenre());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setPlatform(dto.getPlatform());
        entity.setProductionStudio(dto.getProductionStudio());
        entity.setPrice(dto.getPrice());
        entity.setActive(dto.getActive());
        entity.setActivationKey(dto.getActivationKey());
        entity.setDigitalStore(dto.getDigitalStore());
        entity.setDownloadSize(dto.getDownloadSize());
        entity.setLicenseExpiration(dto.getLicenseExpiration());
        entity.setConsoleId(dto.getConsoleId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
