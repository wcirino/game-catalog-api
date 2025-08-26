package com.games.api.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameFilterDTO {
    private Long id;                // filtro por id
    private String title;           // filtro por título
    private String genre;           // filtro por gênero
    private String platform;        // filtro por plataforma
    private Integer releaseYear;    // filtro por ano de lançamento
    private Boolean active;         // filtro por ativo/inativo

    // 🔑 paginação e ordenação
    private Integer page = 0;       // página inicial (default 0)
    private Integer size = 10;      // tamanho da página (default 10)
    private String sort = "id,asc"; // ordenação padrão
}
