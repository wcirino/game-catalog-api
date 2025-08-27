package com.games.api.service.pdf.impl;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGamePhysicalService;
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

class PhysicalGamePdfServiceImplTest {

    @Mock
    private IGamePhysicalService gamePhysicalService;

    @InjectMocks
    private PhysicalGamePdfServiceImpl pdfService;

    private PhysicalGameDTO sampleGame;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleGame = new PhysicalGameDTO(
                1L, "God of War II", "Action-adventure game", "Action",
                2007, "PS2", "Santa Monica Studio", new BigDecimal("79.90"),
                true, "DVD", "Used", "Portuguese", true, 1L, LocalDateTime.now()
        );
    }

    @Test
    void deveGerarPdfComJogosFisicos() {
        when(gamePhysicalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(sampleGame)));

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveGerarPdfMesmoSemJogos() {
        when(gamePhysicalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(Page.empty());

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveLancarExcecaoAoGerarPdf() {
        when(gamePhysicalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenThrow(new RuntimeException("Erro no banco"));

        assertThrows(RuntimeException.class, () -> pdfService.exportPdf(new GameFilterDTO()));
    }
}
