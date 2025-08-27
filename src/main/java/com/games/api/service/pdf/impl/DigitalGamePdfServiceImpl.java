package com.games.api.service.pdf.impl;

import com.games.api.dto.DigitalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameDigitalService;
import com.games.api.service.IDigitalGamePdfService;
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
public class DigitalGamePdfServiceImpl implements IDigitalGamePdfService {

    private final IGameDigitalService gameDigitalService;

    @Override
    public ResponseEntity<ByteArrayResource> exportPdf(GameFilterDTO filter) {
        log.info("Iniciando geração de PDF para Digital Games. Filtros: {}", filter);

        List<DigitalGameDTO> games = gameDigitalService
                .search(filter, PageRequest.of(filter.getPage(), filter.getSize()))
                .getContent();

        log.info("Total de jogos digitais encontrados: {}", games.size());

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("=== Digital Games ==="));
            document.add(new Paragraph("\n"));

            for (DigitalGameDTO g : games) {
                document.add(new Paragraph(g.getTitle() + " (" + g.getPlatform() + " - " + g.getReleaseYear() + ")"));
                document.add(new Paragraph("Genre: " + g.getGenre() + " | Studio: " + g.getProductionStudio()));
                document.add(new Paragraph("Price: " + g.getPrice() + " | Store: " + g.getDigitalStore()));
                document.add(new Paragraph("Activation Key: " + g.getActivationKey() + " | Download Size: " + g.getDownloadSize() + " GB"));
                if (g.getLicenseExpiration() != null) {
                    document.add(new Paragraph("License Expiration: " + g.getLicenseExpiration()));
                }
                document.add(new Paragraph("\n"));
            }

            document.close();

            byte[] pdfBytes = baos.toByteArray();
            log.info("PDF de jogos digitais gerado com sucesso. Tamanho: {} bytes", pdfBytes.length);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=digital-games.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new ByteArrayResource(pdfBytes));

        } catch (DocumentException e) {
            log.error("Erro de formatação ao gerar PDF de Digital Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Digital Games", e);
        } catch (Exception e) {
            log.error("Erro inesperado ao gerar PDF de Digital Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Digital Games", e);
        }
    }
}
