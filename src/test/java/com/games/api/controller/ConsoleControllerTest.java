package com.games.api.controller;

import com.games.api.dto.ConsoleDTO;
import com.games.api.exception.GlobalExceptionHandler;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.service.IConsoleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConsoleController.class)
@Import(GlobalExceptionHandler.class)
class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IConsoleService service;

    @TestConfiguration
    static class MockConfig {
        @Bean
        IConsoleService consoleService() {
            return Mockito.mock(IConsoleService.class);
        }
    }

    @Test
    void shouldReturnAllConsoles() throws Exception {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(1L);
        dto.setName("PS5");
        dto.setManufacturer("Sony");
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/consoles"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("PS5"));
    }

    @Test
    void shouldReturnConsoleById() throws Exception {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(1L);
        dto.setName("Xbox Series X");
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/consoles/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Xbox Series X"));
    }

    @Test
    void shouldReturn404WhenConsoleNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Console not found"));

        mockMvc.perform(get("/api/consoles/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Console not found"))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }

    @Test
    void shouldCreateConsole() throws Exception {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(1L);
        dto.setName("Switch");
        dto.setManufacturer("Nintendo");
        when(service.save(any(ConsoleDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/api/consoles")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"Switch\",\"manufacturer\":\"Nintendo\",\"releaseYear\":2017,\"active\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Switch"));
    }

    @Test
    void shouldUpdateConsole() throws Exception {
        ConsoleDTO dto = new ConsoleDTO();
        dto.setId(1L);
        dto.setName("PS5 Slim");
        when(service.update(eq(1L), any(ConsoleDTO.class))).thenReturn(dto);

        mockMvc.perform(put("/api/consoles/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"name\":\"PS5 Slim\",\"manufacturer\":\"Sony\",\"releaseYear\":2023,\"active\":true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("PS5 Slim"));
    }

    @Test
    void shouldReturn404WhenUpdatingNonExistentConsole() throws Exception {
        when(service.update(eq(99L), any(ConsoleDTO.class)))
                .thenThrow(new ResourceNotFoundException("Console not found"));

        mockMvc.perform(put("/api/consoles/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":99,\"name\":\"Fake\",\"manufacturer\":\"Fake\",\"releaseYear\":2023,\"active\":true}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Console not found"))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }

    @Test
    void shouldDeleteConsole() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/consoles/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn404WhenDeletingNonExistentConsole() throws Exception {
        doThrow(new ResourceNotFoundException("Console not found"))
                .when(service).delete(99L);

        mockMvc.perform(delete("/api/consoles/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Console not found"))
                .andExpect(jsonPath("$.error").value("Not Found"));
    }
}
