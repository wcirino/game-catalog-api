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

import com.games.api.dto.OnlineGameDTO;
import com.games.api.exception.GlobalExceptionHandler;
import com.games.api.exception.ResourceNotFoundException;
import com.games.api.service.IGameOnlineService;

@WebMvcTest(GameOnlineController.class)
@Import(GlobalExceptionHandler.class)
class GameOnlineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IGameOnlineService service;

    @TestConfiguration
    static class MockConfig {
        @Bean
        IGameOnlineService gameOnlineService() {
            return Mockito.mock(IGameOnlineService.class);
        }
    }

    @Test
    void shouldReturnAllOnlineGames() throws Exception {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("Fortnite");
        when(service.findAll()).thenReturn(List.of(dto));

        mockMvc.perform(get("/api/games/online"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Fortnite"));
    }

    @Test
    void shouldReturnOnlineGameById() throws Exception {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("League of Legends");
        when(service.findById(1L)).thenReturn(dto);

        mockMvc.perform(get("/api/games/online/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("League of Legends"));
    }

    @Test
    void shouldReturn404WhenOnlineGameNotFound() throws Exception {
        when(service.findById(99L)).thenThrow(new ResourceNotFoundException("Online game not found"));

        mockMvc.perform(get("/api/games/online/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Online game not found"));
    }

    @Test
    void shouldCreateOnlineGame() throws Exception {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("Fortnite");
        when(service.save(any(OnlineGameDTO.class))).thenReturn(dto);

        mockMvc.perform(post("/api/games/online")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"Fortnite\",\"genre\":\"Battle Royale\",\"platform\":\"PC\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Fortnite"));
    }

    @Test
    void shouldUpdateOnlineGame() throws Exception {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("League of Legends");
        when(service.update(eq(1L), any(OnlineGameDTO.class))).thenReturn(dto);

        mockMvc.perform(put("/api/games/online/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"League of Legends\",\"genre\":\"MOBA\",\"platform\":\"PC\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("League of Legends"));
    }

    @Test
    void shouldReturn404WhenUpdatingNonExistentOnlineGame() throws Exception {
        when(service.update(eq(99L), any(OnlineGameDTO.class)))
                .thenThrow(new ResourceNotFoundException("Online game not found"));

        mockMvc.perform(put("/api/games/online/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":99,\"title\":\"Fake\",\"genre\":\"MOBA\",\"platform\":\"PC\"}"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Online game not found"));
    }

    @Test
    void shouldDeleteOnlineGame() throws Exception {
        doNothing().when(service).delete(1L);

        mockMvc.perform(delete("/api/games/online/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturn404WhenDeletingNonExistentOnlineGame() throws Exception {
        doThrow(new ResourceNotFoundException("Online game not found"))
                .when(service).delete(99L);

        mockMvc.perform(delete("/api/games/online/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Online game not found"));
    }
    
    @Test
    void shouldSearchOnlineGames() throws Exception {
        OnlineGameDTO dto = new OnlineGameDTO();
        dto.setId(1L);
        dto.setTitle("Valorant");

        Page<OnlineGameDTO> page = new PageImpl<>(List.of(dto));
        when(service.search(any(), any())).thenReturn(page);

        mockMvc.perform(get("/api/games/online/search")
                        .param("title", "Valorant")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title").value("Valorant"))
                .andExpect(jsonPath("$.totalElements").value(1));

        verify(service).search(any(), any());
    }

    @Test
    void shouldReturn500WhenSearchFails() throws Exception {
        when(service.search(any(), any()))
                .thenThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(get("/api/games/online/search")
                        .param("title", "Whatever")
                        .param("page", "0")
                        .param("size", "10"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.error").value("Internal Server Error"))
                .andExpect(jsonPath("$.message").value("Unexpected error"));

        verify(service, atLeastOnce()).search(any(), any());
    }
}
