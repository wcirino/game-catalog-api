package com.games.api.service.pdf.impl;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameOnlineService;
import com.games.api.service.IOnlineGamePdfService;
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
public class OnlineGamePdfServiceImpl implements IOnlineGamePdfService {

    private final IGameOnlineService gameOnlineService;

    @Override
    public ResponseEntity<ByteArrayResource> exportPdf(GameFilterDTO filter) {
        log.info("Iniciando geração de PDF para Online Games. Filtros: {}", filter);

        List<OnlineGameDTO> games = gameOnlineService
                .search(filter, PageRequest.of(filter.getPage(), filter.getSize()))
                .getContent();

        log.info("Total de jogos online encontrados: {}", games.size());

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document document = new Document(PageSize.A4);
            PdfWriter.getInstance(document, baos);

            document.open();
            document.add(new Paragraph("=== Online Games ==="));
            document.add(new Paragraph("\n"));

            for (OnlineGameDTO g : games) {
                document.add(new Paragraph(g.getTitle() + " (" + g.getPlatform() + " - " + g.getReleaseYear() + ")"));
                document.add(new Paragraph("Genre: " + g.getGenre() + " | Studio: " + g.getProductionStudio()));
                document.add(new Paragraph("Price: " + g.getPrice() + " | Server: " + g.getServer() + 
                        " | Multiplayer: " + (Boolean.TRUE.equals(g.getMultiplayer()) ? "Yes" : "No")));
                document.add(new Paragraph("Subscription: " + g.getSubscriptionPeriod() + " | Max Players: " + g.getMaxPlayers()));
                document.add(new Paragraph("\n"));
            }

            document.close();

            byte[] pdfBytes = baos.toByteArray();
            log.info("PDF de jogos online gerado com sucesso. Tamanho: {} bytes", pdfBytes.length);

            String filename = "online-games-" + java.time.LocalDate.now() + ".pdf";

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(new ByteArrayResource(pdfBytes));

        } catch (DocumentException e) {
            log.error("Erro de formatação ao gerar PDF de Online Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Online Games", e);
        } catch (Exception e) {
            log.error("Erro inesperado ao gerar PDF de Online Games", e);
            throw new RuntimeException("Erro ao gerar PDF de Online Games", e);
        }
    }
}
