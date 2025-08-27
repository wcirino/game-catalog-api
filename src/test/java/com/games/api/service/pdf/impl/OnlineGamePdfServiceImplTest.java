package com.games.api.service.pdf.impl;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameOnlineService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class OnlineGamePdfServiceImplTest {

    @Mock
    private IGameOnlineService gameOnlineService;

    @InjectMocks
    private OnlineGamePdfServiceImpl pdfService;

    private OnlineGameDTO sampleGame;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleGame = new OnlineGameDTO(
                1L, "Fortnite", "Battle Royale", "Shooter", 2017,
                "PS4", "Epic Games", BigDecimal.ZERO, true,
                "US East", true, "Monthly", 100, 3L, LocalDateTime.now()
        );
    }

    @Test
    void deveGerarPdfComJogosOnline() {
        when(gameOnlineService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(sampleGame)));

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveGerarPdfMesmoSemJogosOnline() {
        when(gameOnlineService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(Page.empty());

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveLancarExcecaoAoGerarPdfOnline() {
        when(gameOnlineService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenThrow(new RuntimeException("Erro no banco"));

        assertThrows(RuntimeException.class, () -> pdfService.exportPdf(new GameFilterDTO()));
    }
}
