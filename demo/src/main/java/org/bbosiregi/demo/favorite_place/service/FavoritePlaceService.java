package org.bbosiregi.demo.favorite_place.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.favorite_place.dto.FavoritePlaceDto;
import org.bbosiregi.demo.favorite_place.repository.FavoritePlaceRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FavoritePlaceService {
    private FavoritePlaceRepository favoritePlaceRepository;
    private final JPAQueryFactory jpaQueryFactory;

    public void checkFavoritePlace(FavoritePlaceDto favoritePlaceDto) {

    }
}
