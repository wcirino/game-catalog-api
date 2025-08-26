package com.games.api.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.entity.OnlineGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.OnlineGameRepository;

@ExtendWith(MockitoExtension.class)
class GameOnlineServiceImplTest {

    @Mock
    private OnlineGameRepository repository;

    @InjectMocks
    private GameOnlineServiceImpl service;

    private OnlineGame buildEntity() {
        OnlineGame g = new OnlineGame();
        g.setId(1L);
        g.setTitle("Fortnite");
        return g;
    }

    private OnlineGameDTO buildDTO() {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("Fortnite");
        return dto;
    }

    @Test
    void shouldReturnAllOnlineGames() {
        when(repository.findAll()).thenReturn(List.of(buildEntity()));
        List<OnlineGameDTO> result = service.findAll();
        assertEquals(1, result.size());
        assertEquals("Fortnite", result.get(0).getTitle());
    }

    @Test
    void shouldReturnOnlineGameById() {
        when(repository.findById(1L)).thenReturn(Optional.of(buildEntity()));
        OnlineGameDTO result = service.findById(1L);
        assertEquals("Fortnite", result.getTitle());
    }

    @Test
    void shouldThrowWhenOnlineGameNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }

    @Test
    void shouldSaveOnlineGame() {
        when(repository.save(any(OnlineGame.class))).thenReturn(buildEntity());
        OnlineGameDTO result = service.save(buildDTO());
        assertEquals("Fortnite", result.getTitle());
    }

    @Test
    void shouldUpdateOnlineGame() {
        OnlineGame existing = buildEntity(); // "Fortnite"
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(OnlineGame.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        OnlineGameDTO dto = buildDTO();
        dto.setTitle("League of Legends");

        OnlineGameDTO result = service.update(1L, dto);

        assertEquals("League of Legends", result.getTitle());
    }

    @Test
    void shouldThrowWhenUpdatingNonExistentOnlineGame() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.update(99L, buildDTO()));
    }

    @Test
    void shouldDeleteOnlineGame() {
        when(repository.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistentOnlineGame() {
        when(repository.existsById(99L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.delete(99L));
    }
    
    @Test
    void shouldSearchOnlineGames() {
        OnlineGame entity = buildEntity();
        entity.setTitle("Apex Legends");

        Page<OnlineGame> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(Mockito.<Specification<OnlineGame>>any(), any(Pageable.class)))
                .thenReturn(page);

        GameFilterDTO filter = new GameFilterDTO();
        Pageable pageable = PageRequest.of(0, 10);

        Page<OnlineGameDTO> result = service.search(filter, pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals("Apex Legends", result.getContent().get(0).getTitle());

        verify(repository).findAll(Mockito.<Specification<OnlineGame>>any(), any(Pageable.class));
    }
}
