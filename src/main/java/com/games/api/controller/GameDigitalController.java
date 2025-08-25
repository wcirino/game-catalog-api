package com.games.api.controller;

import com.games.api.dto.DigitalGameDTO;
import com.games.api.service.IGameDigitalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/games/digital")
@RequiredArgsConstructor
public class GameDigitalController {

    private final IGameDigitalService digitalGameService;

    @GetMapping
    public ResponseEntity<List<DigitalGameDTO>> getAll() {
        log.info("GET /api/games/digital");
        return ResponseEntity.ok(digitalGameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DigitalGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/digital/{}", id);
        return ResponseEntity.ok(digitalGameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DigitalGameDTO> create(@RequestBody DigitalGameDTO dto) {
        log.info("POST /api/games/digital body={}", dto);
        return ResponseEntity.ok(digitalGameService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DigitalGameDTO> update(@PathVariable Long id, @RequestBody DigitalGameDTO dto) {
        log.info("PUT /api/games/digital/{} body={}", id, dto);
        return ResponseEntity.ok(digitalGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/digital/{}", id);
        digitalGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
