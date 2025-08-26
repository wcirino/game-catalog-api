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

import com.games.api.dto.DigitalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.entity.DigitalGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.DigitalGameRepository;

@ExtendWith(MockitoExtension.class)
class GameDigitalServiceImplTest {

    @Mock
    private DigitalGameRepository repository;

    @InjectMocks
    private GameDigitalServiceImpl service;

    private DigitalGame buildEntity() {
        DigitalGame g = new DigitalGame();
        g.setId(1L);
        g.setTitle("Cyberpunk 2077");
        return g;
    }

    private DigitalGameDTO buildDTO() {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Cyberpunk 2077");
        return dto;
    }

    @Test
    void shouldReturnAllDigitalGames() {
        when(repository.findAll()).thenReturn(List.of(buildEntity()));
        List<DigitalGameDTO> result = service.findAll();
        assertEquals(1, result.size());
        assertEquals("Cyberpunk 2077", result.get(0).getTitle());
    }

    @Test
    void shouldReturnDigitalGameById() {
        when(repository.findById(1L)).thenReturn(Optional.of(buildEntity()));
        DigitalGameDTO result = service.findById(1L);
        assertEquals("Cyberpunk 2077", result.getTitle());
    }

    @Test
    void shouldThrowWhenDigitalGameNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }

    @Test
    void shouldSaveDigitalGame() {
        when(repository.save(any(DigitalGame.class))).thenReturn(buildEntity());
        DigitalGameDTO result = service.save(buildDTO());
        assertEquals("Cyberpunk 2077", result.getTitle());
    }

    @Test
    void shouldUpdateDigitalGame() {
        DigitalGame existing = buildEntity(); // "Cyberpunk 2077"
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(DigitalGame.class))).thenAnswer(invocation -> invocation.getArgument(0));

        DigitalGameDTO dto = buildDTO();
        dto.setTitle("Elden Ring");

        DigitalGameDTO result = service.update(1L, dto);

        assertEquals("Elden Ring", result.getTitle());
    }

    @Test
    void shouldThrowWhenUpdatingNonExistentDigitalGame() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.update(99L, buildDTO()));
    }

    @Test
    void shouldDeleteDigitalGame() {
        when(repository.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistentDigitalGame() {
        when(repository.existsById(99L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.delete(99L));
    }
    
    @Test
    void shouldSearchDigitalGames() {
        DigitalGame entity = buildEntity();
        entity.setTitle("Elden Ring");

        Page<DigitalGame> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(Mockito.<Specification<DigitalGame>>any(), any(Pageable.class)))
                .thenReturn(page);

        GameFilterDTO filter = new GameFilterDTO();
        Pageable pageable = PageRequest.of(0, 10);

        Page<DigitalGameDTO> result = service.search(filter, pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals("Elden Ring", result.getContent().get(0).getTitle());

        verify(repository).findAll(Mockito.<Specification<DigitalGame>>any(), any(Pageable.class));
    }

}
