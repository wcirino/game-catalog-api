package com.games.api.repository.specification;

import com.games.api.dto.filter.GameFilterDTO;
import com.games.api.entity.GameBase;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecificationBuilder {

    public static <T extends GameBase> Specification<T> build(GameFilterDTO filter) {
        Specification<T> spec = Specification.where(null);

        if (filter.getId() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("id"), filter.getId()));
        }
        if (filter.getTitle() != null) {
            spec = spec.and((root, query, cb) -> cb.like(cb.lower(root.get("title")), "%" + filter.getTitle().toLowerCase() + "%"));
        }
        if (filter.getGenre() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(cb.lower(root.get("genre")), filter.getGenre().toLowerCase()));
        }
        if (filter.getPlatform() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(cb.lower(root.get("platform")), filter.getPlatform().toLowerCase()));
        }
        if (filter.getReleaseYear() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("releaseYear"), filter.getReleaseYear()));
        }
        if (filter.getActive() != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("active"), filter.getActive()));
        }

        return spec;
    }
}
