package com.games.api.controller;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.service.IGameOnlineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/games/online")
@RequiredArgsConstructor
public class GameOnlineController {

    private final IGameOnlineService onlineGameService;

    @GetMapping
    public ResponseEntity<List<OnlineGameDTO>> getAll() {
        log.info("GET /api/games/online");
        return ResponseEntity.ok(onlineGameService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OnlineGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/online/{}", id);
        return ResponseEntity.ok(onlineGameService.findById(id));
    }

    @PostMapping
    public ResponseEntity<OnlineGameDTO> create(@RequestBody OnlineGameDTO dto) {
        log.info("POST /api/games/online body={}", dto);
        return ResponseEntity.ok(onlineGameService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OnlineGameDTO> update(@PathVariable Long id, @RequestBody OnlineGameDTO dto) {
        log.info("PUT /api/games/online/{} body={}", id, dto);
        return ResponseEntity.ok(onlineGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/online/{}", id);
        onlineGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
