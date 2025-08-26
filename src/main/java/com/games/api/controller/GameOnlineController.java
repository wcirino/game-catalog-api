package com.games.api.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameOnlineService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/games/online")
@RequiredArgsConstructor
@Tag(name = "Online Games", description = "Operations related to online games")
public class GameOnlineController {

    private final IGameOnlineService onlineGameService;

    @GetMapping
    @Operation(summary = "List all online games")
    public ResponseEntity<List<OnlineGameDTO>> getAll() {
        log.info("GET /api/games/online");
        return ResponseEntity.ok(onlineGameService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find online game by ID")
    public ResponseEntity<OnlineGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/online/{}", id);
        return ResponseEntity.ok(onlineGameService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create new online game")
    public ResponseEntity<OnlineGameDTO> create(@RequestBody OnlineGameDTO dto) {
        log.info("POST /api/games/online body={}", dto);
        return ResponseEntity.ok(onlineGameService.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing online game")
    public ResponseEntity<OnlineGameDTO> update(@PathVariable Long id, @RequestBody OnlineGameDTO dto) {
        log.info("PUT /api/games/online/{} body={}", id, dto);
        return ResponseEntity.ok(onlineGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete online game by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/online/{}", id);
        onlineGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    @Operation(summary = "Search online games with filters")
    public ResponseEntity<Page<OnlineGameDTO>> search(@ModelAttribute GameFilterDTO filter, Pageable pageable) {
        Pageable noSortPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.unsorted());
        log.info("GET /api/games/online/search filter={}", filter);
        return ResponseEntity.ok(onlineGameService.search(filter, noSortPageable));
    }
}
