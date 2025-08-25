package com.games.api.service;

import com.games.api.dto.OnlineGameDTO;
import java.util.List;

public interface IGameOnlineService {
    List<OnlineGameDTO> findAll();
    OnlineGameDTO findById(Long id);
    OnlineGameDTO save(OnlineGameDTO dto);
    OnlineGameDTO update(Long id, OnlineGameDTO dto);
    void delete(Long id);
}
