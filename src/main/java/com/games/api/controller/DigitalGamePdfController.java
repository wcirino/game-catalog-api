package com.games.api.controller;

import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IDigitalGamePdfService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pdf/digital-games")
@RequiredArgsConstructor
@Tag(name = "PDF Export - Digital Games", description = "Exportação de relatórios em PDF para jogos digitais")
public class DigitalGamePdfController {

    private final IDigitalGamePdfService pdfService;

    @Operation(
        summary = "Exportar PDF de jogos digitais",
        description = "Gera um PDF com a listagem de jogos digitais de acordo com os filtros informados",
        responses = {
            @ApiResponse(responseCode = "200", description = "PDF gerado com sucesso",
                content = @Content(mediaType = "application/pdf",
                    schema = @Schema(type = "string", format = "binary"))),
            @ApiResponse(responseCode = "400", description = "Requisição inválida"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao gerar PDF")
        }
    )
    @PostMapping(produces = "application/pdf")
    public ResponseEntity<ByteArrayResource> exportPdf(@RequestBody GameFilterDTO filter) {
        return pdfService.exportPdf(filter);
    }
}
