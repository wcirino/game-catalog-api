package com.games.api.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.games.api.dto.OnlineGameDTO;
import com.games.api.dto.filter.GameFilterDTO;

public interface IGameOnlineService {
    List<OnlineGameDTO> findAll();
    OnlineGameDTO findById(Long id);
    OnlineGameDTO save(OnlineGameDTO dto);
    OnlineGameDTO update(Long id, OnlineGameDTO dto);
    void delete(Long id);
    Page<OnlineGameDTO> search(GameFilterDTO filter, Pageable pageable);
}
