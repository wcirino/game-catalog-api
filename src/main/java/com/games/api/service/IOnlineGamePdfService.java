package com.games.api.service;

import com.games.api.dto.filter.GameFilterDTO;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;

public interface IOnlineGamePdfService {
    ResponseEntity<ByteArrayResource> exportPdf(GameFilterDTO filter);
}
