package org.bbosiregi.demo.favorite_place.repository;

import org.bbosiregi.demo.favorite_place.entity.FavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritePlaceRepository extends JpaRepository<FavoritePlace,Long> {
}
