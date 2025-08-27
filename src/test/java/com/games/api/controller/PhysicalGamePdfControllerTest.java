package com.games.api.controller;

import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IPhysicalGamePdfService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class PhysicalGamePdfControllerTest {

    private IPhysicalGamePdfService pdfService;
    private PhysicalGamePdfController controller;

    @BeforeEach
    void setup() {
        pdfService = Mockito.mock(IPhysicalGamePdfService.class);
        controller = new PhysicalGamePdfController(pdfService);
    }

    @Test
    void deveExportarPdfComSucesso() {
        byte[] pdfBytes = "fake-pdf".getBytes();
        ResponseEntity<ByteArrayResource> responseMock = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=physical-games.pdf")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(new ByteArrayResource(pdfBytes));

        Mockito.when(pdfService.exportPdf(any(GameFilterDTO.class))).thenReturn(responseMock);

        ResponseEntity<ByteArrayResource> response = controller.exportPdf(new GameFilterDTO());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertArrayEquals(pdfBytes, response.getBody().getByteArray());
        assertTrue(response.getHeaders().getFirst(HttpHeaders.CONTENT_DISPOSITION).contains("physical-games.pdf"));
        assertEquals("application/pdf", response.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE));
    }

    @Test
    void deveGerarPdfMesmoSeBodyEstiverVazio() {
        ResponseEntity<ByteArrayResource> responseMock = ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=physical-games.pdf")
                .header(HttpHeaders.CONTENT_TYPE, "application/pdf")
                .body(new ByteArrayResource(new byte[0]));

        Mockito.when(pdfService.exportPdf(any(GameFilterDTO.class))).thenReturn(responseMock);

        ResponseEntity<ByteArrayResource> response = controller.exportPdf(new GameFilterDTO());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(0, response.getBody().contentLength());
    }

    @Test
    void devePropagarExcecaoAoGerarPdf() {
        Mockito.when(pdfService.exportPdf(any(GameFilterDTO.class)))
                .thenThrow(new RuntimeException("Erro interno"));

        assertThrows(RuntimeException.class, () -> controller.exportPdf(new GameFilterDTO()));
    }

    @Test
    void deveAceitarFiltroNuloSemErro() {
        byte[] pdfBytes = "fake-pdf".getBytes();
        ResponseEntity<ByteArrayResource> responseMock = ResponseEntity.ok(new ByteArrayResource(pdfBytes));

        Mockito.when(pdfService.exportPdf(null)).thenReturn(responseMock);

        ResponseEntity<ByteArrayResource> response = controller.exportPdf(null);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
}
