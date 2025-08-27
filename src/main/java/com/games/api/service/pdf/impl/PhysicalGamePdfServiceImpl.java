package com.games.api.service.pdf.impl;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGamePhysicalService;
import com.games.api.service.IPhysicalGamePdfService;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhysicalGamePdfServiceImpl implements IPhysicalGamePdfService {

    private final IGamePhysicalService gamePhysicalService;

    @Override
    public ResponseEntity<ByteArrayResource> exportPdf(GameFilterDTO filter) {
        log.info("Iniciando geração de PDF para Physical Games. Filtros: {}", filter);

        List<PhysicalGameDTO> games = gamePhysicalService
                .search(filter, PageRequest.of(filter.getPage(), filter.getSize()))
                .getContent();

        log.info("Total de jogos físicos encontrados: {}", games.size());

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("=== Physical Games ==="));
            document.add(new Paragraph("\n"));

            for (PhysicalGameDTO g : games) {
                document.add(new Paragraph(g.getTitle() + " (" + g.getPlatform() + " - " + g.getReleaseYear() + ")"));
                document.add(new Paragraph("Genre: " + g.getGenre() + " | Studio: " + g.getProductionStudio()));
                document.add(new Paragraph("Price: " + g.getPrice() + " | Media: " + g.getMediaType() + " | Condition: " + g.getConditionStatus()));
                document.add(new Paragraph("Manual: " + g.getManualLanguage() + " | Has Box: " + (Boolean.TRUE.equals(g.getHasBox()) ? "Yes" : "No")));
                document.add(new Paragraph("\n"));
            }

            document.close();

            byte[] pdfBytes = baos.toByteArray();
            log.info("PDF de jogos físicos gerado com sucesso. Tamanho: {} bytes", pdfBytes.length);

            String filename = "physical-games-" + java.time.LocalDate.now() + ".pdf";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new ByteArrayResource(pdfBytes));

        } catch (DocumentException e) {
            log.error("Erro de formatação ao gerar PDF de Physical Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Physical Games", e);
        } catch (Exception e) {
            log.error("Erro inesperado ao gerar PDF de Physical Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Physical Games", e);
        }
    }
}
