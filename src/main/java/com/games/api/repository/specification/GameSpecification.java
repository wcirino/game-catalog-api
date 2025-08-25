package com.games.api.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import com.games.api.entity.GameBase;

public class GameSpecification {

    public static Specification<GameBase> hasTitle(String title) {
        return (root, query, cb) ->
                title == null ? null : cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<GameBase> hasGenre(String genre) {
        return (root, query, cb) ->
                genre == null ? null : cb.equal(cb.lower(root.get("genre")), genre.toLowerCase());
    }

    public static Specification<GameBase> hasPlatform(String platform) {
        return (root, query, cb) ->
                platform == null ? null : cb.equal(cb.lower(root.get("platform")), platform.toLowerCase());
    }

    public static Specification<GameBase> hasReleaseYear(Integer releaseYear) {
        return (root, query, cb) ->
                releaseYear == null ? null : cb.equal(root.get("releaseYear"), releaseYear);
    }

    public static Specification<GameBase> isActive(Boolean active) {
        return (root, query, cb) ->
                active == null ? null : cb.equal(root.get("active"), active);
    }
}

