package com.games.api.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

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

import com.games.api.dto.DigitalGameDTO;
import com.games.api.exception.GlobalExceptionHandler;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.service.IGameDigitalService;

@WebMvcTest(GameDigitalController.class)
@Import(GlobalExceptionHandler.class)
class GameDigitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IGameDigitalService service;

    @TestConfiguration
    static class MockConfig {
        @Bean
        IGameDigitalService gameDigitalService() {
            return Mockito.mock(IGameDigitalService.class);
        }
    }

    @Test
    void shouldReturnAllDigitalGames() throws Exception {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Cyberpunk 2077");
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/games/digital"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Cyberpunk 2077"));
    }

    @Test
    void shouldReturnDigitalGameById() throws Exception {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Elden Ring");
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/games/digital/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Elden Ring"));
    }

    @Test
    void shouldReturn404WhenDigitalGameNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Digital game not found"));

        mockMvc.perform(get("/api/games/digital/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Digital game not found"));
    }

    @Test
    void shouldCreateDigitalGame() throws Exception {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Cyberpunk 2077");
        when(service.save(any(DigitalGameDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/api/games/digital")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Cyberpunk 2077\",\"genre\":\"RPG\",\"platform\":\"PC\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Cyberpunk 2077"));
    }

    @Test
    void shouldUpdateDigitalGame() throws Exception {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Elden Ring");
        when(service.update(eq(1L), any(DigitalGameDTO.class))).thenReturn(dto);

        mockMvc.perform(put("/api/games/digital/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Elden Ring\",\"genre\":\"RPG\",\"platform\":\"PC\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Elden Ring"));
    }

    @Test
    void shouldReturn404WhenUpdatingNonExistentDigitalGame() throws Exception {
        when(service.update(eq(99L), any(DigitalGameDTO.class)))
                .thenThrow(new ResourceNotFoundException("Digital game not found"));

        mockMvc.perform(put("/api/games/digital/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":99,\"title\":\"Fake\",\"genre\":\"RPG\",\"platform\":\"PC\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Digital game not found"));
    }

    @Test
    void shouldDeleteDigitalGame() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/games/digital/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn404WhenDeletingNonExistentDigitalGame() throws Exception {
        doThrow(new ResourceNotFoundException("Digital game not found"))
                .when(service).delete(99L);

        mockMvc.perform(delete("/api/games/digital/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Digital game not found"));
    }
    
    @Test
    void shouldSearchDigitalGames() throws Exception {
        DigitalGameDTO dto = new DigitalGameDTO();
        dto.setId(1L);
        dto.setTitle("Hollow Knight");

        Page<DigitalGameDTO> page = new PageImpl<>(List.of(dto));
        when(service.search(any(), any())).thenReturn(page);

        mockMvc.perform(get("/api/games/digital/search")
                        .param("title", "Hollow")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("Hollow Knight"))
                .andExpect(jsonPath("$.totalElements").value(1));

        verify(service).search(any(), any());
    }
    
    @Test
    void shouldReturn500WhenSearchFails() throws Exception {
        when(service.search(any(), any()))
                .thenThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(get("/api/games/digital/search")
                        .param("title", "Whatever")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error").value("Internal Server Error"))
                .andExpect(jsonPath("$.message").value("Unexpected error"));

        verify(service, atLeastOnce()).search(any(), any());
    }
}
