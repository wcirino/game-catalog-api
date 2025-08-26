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

import com.games.api.dto.PhysicalGameDTO;
import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.service.IGamePhysicalService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/games/physical")
@RequiredArgsConstructor
@Tag(name = "Physical Games", description = "Operations related to physical games")
public class GamePhysicalController {

    private final IGamePhysicalService physicalGameService;

    @GetMapping
    @Operation(summary = "List all physical games")
    public ResponseEntity<List<PhysicalGameDTO>> getAll() {
        log.info("GET /api/games/physical");
        return ResponseEntity.ok(physicalGameService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find physical game by ID")
    public ResponseEntity<PhysicalGameDTO> getById(@PathVariable Long id) {
        log.info("GET /api/games/physical/{}", id);
        return ResponseEntity.ok(physicalGameService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Create new physical game")
    public ResponseEntity<PhysicalGameDTO> create(@RequestBody PhysicalGameDTO dto) {
        log.info("POST /api/games/physical body={}", dto);
        return ResponseEntity.ok(physicalGameService.save(dto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update existing physical game")
    public ResponseEntity<PhysicalGameDTO> update(@PathVariable Long id, @RequestBody PhysicalGameDTO dto) {
        log.info("PUT /api/games/physical/{} body={}", id, dto);
        return ResponseEntity.ok(physicalGameService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete physical game by ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("DELETE /api/games/physical/{}", id);
        physicalGameService.delete(id);
        return ResponseEntity.noContent().build();
    }
        
    @GetMapping("/search")
    @Operation(summary = "Search physical games with filters")
    public ResponseEntity<Page<PhysicalGameDTO>> search(
            @ModelAttribute GameFilterDTO filter,
            Pageable pageable) {
        
        Pageable noSortPageable = PageRequest.of(
            pageable.getPageNumber(),
            pageable.getPageSize(),
            Sort.unsorted()
        );

        log.info("GET /api/games/physical/search filter={}", filter);
        return ResponseEntity.ok(physicalGameService.search(filter, noSortPageable));
    }
}
