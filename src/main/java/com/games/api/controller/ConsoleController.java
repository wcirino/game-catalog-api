package com.games.api.controller;

import com.games.api.dto.ConsoleDTO;
import com.games.api.service.IConsoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/consoles")
@RequiredArgsConstructor
@Tag(name = "Consoles", description = "Operations related to consoles")
public class ConsoleController {

    private final IConsoleService consoleService;

    @GetMapping
    @Operation(summary = "List all consoles")
    public ResponseEntity<List<ConsoleDTO>> getAll() {
        log.info("GET /api/consoles");
        return ResponseEntity.ok(consoleService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find console by ID")
    public ResponseEntity<ConsoleDTO> getById(@PathVariable Long id) {
        log.info("GET /api/consoles/{}", id);
        return ResponseEntity.ok(consoleService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create new console")
    public ResponseEntity<ConsoleDTO> create(@RequestBody ConsoleDTO dto) {
        log.info("POST /api/consoles body={}", dto);
        return ResponseEntity.ok(consoleService.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing console")
    public ResponseEntity<ConsoleDTO> update(@PathVariable Long id, @RequestBody ConsoleDTO dto) {
        log.info("PUT /api/consoles/{} body={}", id, dto);
        return ResponseEntity.ok(consoleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete console by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/consoles/{}", id);
        consoleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
