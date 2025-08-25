package com.games.api.controller;

import com.games.api.dto.ConsoleDTO;
import com.games.api.service.IConsoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/consoles")
@RequiredArgsConstructor
public class ConsoleController {

    private final IConsoleService consoleService;

    @GetMapping
    public ResponseEntity<List<ConsoleDTO>> getAll() {
        log.info("GET /api/consoles");
        return ResponseEntity.ok(consoleService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsoleDTO> getById(@PathVariable Long id) {
        log.info("GET /api/consoles/{}", id);
        return ResponseEntity.ok(consoleService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ConsoleDTO> create(@RequestBody ConsoleDTO dto) {
        log.info("POST /api/consoles body={}", dto);
        return ResponseEntity.ok(consoleService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsoleDTO> update(@PathVariable Long id, @RequestBody ConsoleDTO dto) {
        log.info("PUT /api/consoles/{} body={}", id, dto);
        return ResponseEntity.ok(consoleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/consoles/{}", id);
        consoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
