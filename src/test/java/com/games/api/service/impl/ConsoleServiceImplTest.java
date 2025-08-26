package com.games.api.service.impl;

import com.games.api.dto.ConsoleDTO;
import com.games.api.entity.Console;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.repository.ConsoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsoleServiceImplTest {

    @Mock
    private ConsoleRepository repository;

    @InjectMocks
    private ConsoleServiceImpl service;

    private Console buildEntity() {
        return new Console(1L, "PS5", "Sony", 2020, null, true);
    }

    private ConsoleDTO buildDTO() {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(1L);
        dto.setName("PS5");
        dto.setManufacturer("Sony");
        dto.setReleaseYear(2020);
        dto.setActive(true);
        return dto;
    }

    @Test
    void shouldReturnAllConsoles() {
        when(repository.findAll()).thenReturn(List.of(buildEntity()));

        List<ConsoleDTO> result = service.findAll();

        assertEquals(1, result.size());
        assertEquals("PS5", result.get(0).getName());
        verify(repository).findAll();
    }

    @Test
    void shouldReturnConsoleById() {
        when(repository.findById(1L)).thenReturn(Optional.of(buildEntity()));

        ConsoleDTO result = service.findById(1L);

        assertEquals("PS5", result.getName());
        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowWhenConsoleNotFound() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.findById(99L));
    }

    @Test
    void shouldSaveConsole() {
        Console entity = buildEntity();
        when(repository.save(any(Console.class))).thenReturn(entity);

        ConsoleDTO result = service.save(buildDTO());

        assertNotNull(result);
        assertEquals("PS5", result.getName());
        verify(repository).save(any(Console.class));
    }

    @Test
    void shouldUpdateConsole() {
        Console existing = buildEntity();
        when(repository.findById(1L)).thenReturn(Optional.of(existing));
        when(repository.save(any(Console.class))).thenReturn(existing);

        ConsoleDTO dto = buildDTO();
        dto.setName("Xbox Series X");
        ConsoleDTO result = service.update(1L, dto);

        assertEquals("Xbox Series X", result.getName());
        verify(repository).save(existing);
    }

    @Test
    void shouldThrowWhenUpdatingNonExistentConsole() {
        when(repository.findById(99L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.update(99L, buildDTO()));
    }

    @Test
    void shouldDeleteConsole() {
        when(repository.existsById(1L)).thenReturn(true);
        service.delete(1L);
        verify(repository).deleteById(1L);
    }

    @Test
    void shouldThrowWhenDeletingNonExistentConsole() {
        when(repository.existsById(99L)).thenReturn(false);
        assertThrows(ResourceNotFoundException.class, () -> service.delete(99L));
    }
}
