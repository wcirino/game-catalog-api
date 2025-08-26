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

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.entity.PhysicalGame;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.PhysicalGameRepository;

@ExtendWith(MockitoExtension.class)
class GamePhysicalServiceImplTest {

    @Mock
    private PhysicalGameRepository repository;

    @InjectMocks
    private GamePhysicalServiceImpl service;

    private PhysicalGame buildEntity() {
        PhysicalGame g = new PhysicalGame();
        g.setId(1L);
        g.setTitle("FIFA 23");
        return g;
    }

    private PhysicalGameDTO buildDTO() {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("FIFA 23");
        return dto;
    }

    @Test
    void shouldReturnAllPhysicalGames() {
        when(repository.findAll()).thenReturn(List.of(buildEntity()));
        List<PhysicalGameDTO> result = service.findAll();
        assertEquals(1, result.size());
        assertEquals("FIFA 23", result.get(0).getTitle());
    }

    @Test
    void shouldReturnPhysicalGameById() {
        when(repository.findById(1L)).thenReturn(Optional.of(buildEntity()));
        PhysicalGameDTO result = service.findById(1L);
        assertEquals("FIFA 23", result.getTitle());
    }

    @Test
    void shouldThrowWhenPhysicalGameNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }

    @Test
    void shouldSavePhysicalGame() {
        when(repository.save(any(PhysicalGame.class))).thenReturn(buildEntity());
        PhysicalGameDTO result = service.save(buildDTO());
        assertEquals("FIFA 23", result.getTitle());
    }

    @Test
    void shouldUpdatePhysicalGame() {
        PhysicalGame existing = buildEntity(); // "FIFA 23"
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(PhysicalGame.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        PhysicalGameDTO dto = buildDTO();
        dto.setTitle("PES 23");

        PhysicalGameDTO result = service.update(1L, dto);

        assertEquals("PES 23", result.getTitle());
    }

    @Test
    void shouldThrowWhenUpdatingNonExistentPhysicalGame() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.update(99L, buildDTO()));
    }

    @Test
    void shouldDeletePhysicalGame() {
        when(repository.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistentPhysicalGame() {
        when(repository.existsById(99L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.delete(99L));
    }
    
    @Test
    void shouldSearchPhysicalGames() {
        PhysicalGame entity = buildEntity();
        entity.setTitle("God of War");

        Page<PhysicalGame> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(Mockito.<Specification<PhysicalGame>>any(), any(Pageable.class)))
                .thenReturn(page);

        GameFilterDTO filter = new GameFilterDTO();
        Pageable pageable = PageRequest.of(0, 10);

        Page<PhysicalGameDTO> result = service.search(filter, pageable);

        assertEquals(1, result.getTotalElements());
        assertEquals("God of War", result.getContent().get(0).getTitle());

        verify(repository).findAll(Mockito.<Specification<PhysicalGame>>any(), any(Pageable.class));
    }
}
