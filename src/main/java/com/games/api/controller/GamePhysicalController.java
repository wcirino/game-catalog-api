package com.games.api.controller;

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.service.IGamePhysicalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/games/physical")
@RequiredArgsConstructor
public class GamePhysicalController {

    private final IGamePhysicalService physicalGameService;

    @GetMapping
    public ResponseEntity<List<PhysicalGameDTO>> getAll() {
        log.info("GET /api/games/physical");
        return ResponseEntity.ok(physicalGameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhysicalGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/physical/{}", id);
        return ResponseEntity.ok(physicalGameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PhysicalGameDTO> create(@RequestBody PhysicalGameDTO dto) {
        log.info("POST /api/games/physical body={}", dto);
        return ResponseEntity.ok(physicalGameService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhysicalGameDTO> update(@PathVariable Long id, @RequestBody PhysicalGameDTO dto) {
        log.info("PUT /api/games/physical/{} body={}", id, dto);
        return ResponseEntity.ok(physicalGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/physical/{}", id);
        physicalGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
