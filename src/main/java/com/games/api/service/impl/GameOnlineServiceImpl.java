package com.games.api.service.impl;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.entity.OnlineGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.OnlineGameRepository;
import com.games.api.service.IGameOnlineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameOnlineServiceImpl implements IGameOnlineService {

    private final OnlineGameRepository repository;

    @Override
    public List<OnlineGameDTO> findAll() {
        log.info("Fetching all online games...");
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @Override
    public OnlineGameDTO findById(Long id) {
        log.info("Fetching online game by id: {}", id);
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Online game not found with id: " + id));
    }

    @Override
    public OnlineGameDTO save(OnlineGameDTO dto) {
        log.info("Saving new online game: {}", dto.getTitle());
        OnlineGame saved = repository.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public OnlineGameDTO update(Long id, OnlineGameDTO dto) {
        log.info("Updating online game with id: {}", id);
        OnlineGame existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Online game not found with id: " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setGenre(dto.getGenre());
        existing.setReleaseYear(dto.getReleaseYear());
        existing.setPlatform(dto.getPlatform());
        existing.setProductionStudio(dto.getProductionStudio());
        existing.setPrice(dto.getPrice());
        existing.setActive(dto.getActive());
        existing.setServer(dto.getServer());
        existing.setMultiplayer(dto.getMultiplayer());
        existing.setSubscriptionPeriod(dto.getSubscriptionPeriod());
        existing.setMaxPlayers(dto.getMaxPlayers());
        existing.setConsoleId(dto.getConsoleId());

        return toDTO(repository.save(existing));
    }

    @Override
    public void delete(Long id) {
        log.info("Deleting online game with id: {}", id);
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Online game not found with id: " + id);
        }
        repository.deleteById(id);
    }

    private OnlineGameDTO toDTO(OnlineGame entity) {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setGenre(entity.getGenre());
        dto.setReleaseYear(entity.getReleaseYear());
        dto.setPlatform(entity.getPlatform());
        dto.setProductionStudio(entity.getProductionStudio());
        dto.setPrice(entity.getPrice());
        dto.setActive(entity.getActive());
        dto.setServer(entity.getServer());
        dto.setMultiplayer(entity.getMultiplayer());
        dto.setSubscriptionPeriod(entity.getSubscriptionPeriod());
        dto.setMaxPlayers(entity.getMaxPlayers());
        dto.setConsoleId(entity.getConsoleId());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private OnlineGame toEntity(OnlineGameDTO dto) {
        OnlineGame entity = new OnlineGame();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setGenre(dto.getGenre());
        entity.setReleaseYear(dto.getReleaseYear());
        entity.setPlatform(dto.getPlatform());
        entity.setProductionStudio(dto.getProductionStudio());
        entity.setPrice(dto.getPrice());
        entity.setActive(dto.getActive());
        entity.setServer(dto.getServer());
        entity.setMultiplayer(dto.getMultiplayer());
        entity.setSubscriptionPeriod(dto.getSubscriptionPeriod());
        entity.setMaxPlayers(dto.getMaxPlayers());
        entity.setConsoleId(dto.getConsoleId());
        entity.setCreatedAt(dto.getCreatedAt());
        return entity;
    }
}
