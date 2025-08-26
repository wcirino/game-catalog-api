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

import com.games.api.dto.DigitalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGameDigitalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/games/digital")
@RequiredArgsConstructor
@Tag(name = "Digital Games", description = "Operations related to digital games")
public class GameDigitalController {

    private final IGameDigitalService digitalGameService;

    @GetMapping
    @Operation(summary = "List all digital games")
    public ResponseEntity<List<DigitalGameDTO>> getAll() {
        log.info("GET /api/games/digital");
        return ResponseEntity.ok(digitalGameService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find digital game by ID")
    public ResponseEntity<DigitalGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/digital/{}", id);
        return ResponseEntity.ok(digitalGameService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create new digital game")
    public ResponseEntity<DigitalGameDTO> create(@RequestBody DigitalGameDTO dto) {
        log.info("POST /api/games/digital body={}", dto);
        return ResponseEntity.ok(digitalGameService.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing digital game")
    public ResponseEntity<DigitalGameDTO> update(@PathVariable Long id, @RequestBody DigitalGameDTO dto) {
        log.info("PUT /api/games/digital/{} body={}", id, dto);
        return ResponseEntity.ok(digitalGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete digital game by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/digital/{}", id);
        digitalGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    @Operation(summary = "Search digital games with filters")
    public ResponseEntity<Page<DigitalGameDTO>> search(@ModelAttribute GameFilterDTO filter, Pageable pageable) {
        Pageable noSortPageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.unsorted());
        log.info("GET /api/games/digital/search filter={}", filter);
        return ResponseEntity.ok(digitalGameService.search(filter, noSortPageable));
    }

}
