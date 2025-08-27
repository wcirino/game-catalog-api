package com.games.api.service.pdf.impl;

import com.games.api.dto.DigitalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameDigitalService;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class DigitalGamePdfServiceImplTest {

    @Mock
    private IGameDigitalService gameDigitalService;

    @InjectMocks
    private DigitalGamePdfServiceImpl pdfService;

    private DigitalGameDTO sampleGame;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleGame = new DigitalGameDTO(
                1L, "Cyberpunk 2077", "Futuristic RPG", "RPG", 2020,
                "PS5", "CD Projekt Red", new BigDecimal("249.90"), true,
                "CYB-9876-5432-WXYZ", "PSN", new BigDecimal("70.00"),
                LocalDate.now().plusYears(1), 4L, LocalDateTime.now()
        );
    }

    @Test
    void deveGerarPdfComJogosDigitais() {
        when(gameDigitalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(new PageImpl<>(List.of(sampleGame)));

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveGerarPdfMesmoSemJogosDigitais() {
        when(gameDigitalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenReturn(Page.empty());

        ResponseEntity<ByteArrayResource> response = pdfService.exportPdf(new GameFilterDTO());

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contentLength() > 0);
    }

    @Test
    void deveLancarExcecaoAoGerarPdfDigital() {
        when(gameDigitalService.search(any(GameFilterDTO.class), any(Pageable.class)))
                .thenThrow(new RuntimeException("Erro no banco"));

        assertThrows(RuntimeException.class, () -> pdfService.exportPdf(new GameFilterDTO()));
    }
}
