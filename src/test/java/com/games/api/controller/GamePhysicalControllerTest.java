package com.games.api.controller;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.exception.GlobalExceptionHandler;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.service.IGamePhysicalService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GamePhysicalController.class)
@Import(GlobalExceptionHandler.class)
class GamePhysicalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IGamePhysicalService service;

    @TestConfiguration
    static class MockConfig {
        @Bean
        IGamePhysicalService gamePhysicalService() {
            return Mockito.mock(IGamePhysicalService.class);
        }
    }

    @Test
    void shouldReturnAllPhysicalGames() throws Exception {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("FIFA 23");
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/games/physical"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("FIFA 23"));
    }

    @Test
    void shouldReturnPhysicalGameById() throws Exception {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("FIFA 23");
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/games/physical/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("FIFA 23"));
    }

    @Test
    void shouldReturn404WhenPhysicalGameNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Physical game not found"));

        mockMvc.perform(get("/api/games/physical/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Physical game not found"));
    }

    @Test
    void shouldCreatePhysicalGame() throws Exception {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("FIFA 23");
        when(service.save(any(PhysicalGameDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/api/games/physical")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"FIFA 23\",\"genre\":\"Sports\",\"platform\":\"PS5\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("FIFA 23"));
    }

    @Test
    void shouldUpdatePhysicalGame() throws Exception {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("PES 23");
        when(service.update(eq(1L), any(PhysicalGameDTO.class))).thenReturn(dto);

        mockMvc.perform(put("/api/games/physical/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"PES 23\",\"genre\":\"Sports\",\"platform\":\"PS5\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("PES 23"));
    }

    @Test
    void shouldReturn404WhenUpdatingNonExistentPhysicalGame() throws Exception {
        when(service.update(eq(99L), any(PhysicalGameDTO.class)))
                .thenThrow(new ResourceNotFoundException("Physical game not found"));

        mockMvc.perform(put("/api/games/physical/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":99,\"title\":\"Fake\",\"genre\":\"Sports\",\"platform\":\"PS5\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Physical game not found"));
    }

    @Test
    void shouldDeletePhysicalGame() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/games/physical/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn404WhenDeletingNonExistentPhysicalGame() throws Exception {
        doThrow(new ResourceNotFoundException("Physical game not found"))
                .when(service).delete(99L);

        mockMvc.perform(delete("/api/games/physical/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Physical game not found"));
    }

    @Test
    void shouldSearchPhysicalGames() throws Exception {
        PhysicalGameDTO dto = new PhysicalGameDTO();
        dto.setId(1L);
        dto.setTitle("NBA 2K24");

        Page<PhysicalGameDTO> page = new PageImpl<>(List.of(dto));
        when(service.search(any(), any())).thenReturn(page);

        mockMvc.perform(get("/api/games/physical/search")
                        .param("title", "NBA")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("NBA 2K24"))
                .andExpect(jsonPath("$.totalElements").value(1));

        verify(service, atLeastOnce()).search(any(), any());
    }

    @Test
    void shouldReturn500WhenSearchFails() throws Exception {
        when(service.search(any(), any()))
                .thenThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(get("/api/games/physical/search")
                        .param("title", "Whatever")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error").value("Internal Server Error"))
                .andExpect(jsonPath("$.message").value("Unexpected error"));

        verify(service, atLeastOnce()).search(any(), any());
    }
}
