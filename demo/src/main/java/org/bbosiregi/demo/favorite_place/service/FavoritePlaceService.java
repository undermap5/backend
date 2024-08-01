package org.bbosiregi.demo.favorite_place.service;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.favorite_place.dto.FavoritePlaceDto;
import org.bbosiregi.demo.favorite_place.dto.UserFavoriteDto;
import org.bbosiregi.demo.favorite_place.entity.FavoritePlace;
import org.bbosiregi.demo.favorite_place.entity.QFavoritePlace;
import org.bbosiregi.demo.favorite_place.repository.FavoritePlaceRepository;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.subway_info.entity.QSubwayInfo;
import org.bbosiregi.demo.user.entity.QUsers;
import org.bbosiregi.demo.user.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritePlaceService {
    private FavoritePlaceRepository favoritePlaceRepository;
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;

    public void checkFavoritePlace(FavoritePlaceDto favoritePlaceDto) {
        QUsers qUsers = QUsers.users;
        QSubwayInfo qSubwayInfo = QSubwayInfo.subwayInfo1;

        Users user = queryFactory.selectFrom(qUsers)
                .where(qUsers.uid.eq(favoritePlaceDto.userUid()))
                .fetchOne();

        SubwayInfo subwayInfo = queryFactory.selectFrom(qSubwayInfo)
                .where(qSubwayInfo.subwayName.eq(favoritePlaceDto.subwayName()))
                .fetchOne();

        if (user != null && subwayInfo != null) {
            FavoritePlace favoritePlace = FavoritePlace.builder()
                    .users(user)
                    .subwayInfo(subwayInfo)
                    .build();
            entityManager.persist(favoritePlace);
        }
    }

    public List<SubwayInfo> findFavoritePlace(UserFavoriteDto userFavoriteDto) {
        QFavoritePlace qFavoritePlace = QFavoritePlace.favoritePlace;
        QUsers qUsers = QUsers.users;
        QSubwayInfo qSubwayInfo = QSubwayInfo.subwayInfo1;

        return queryFactory.select(qFavoritePlace.subwayInfo)
                .from(qFavoritePlace)
                .join(qFavoritePlace.users, qUsers)
                .join(qFavoritePlace.subwayInfo, qSubwayInfo)
                .where(qUsers.uid.eq(userFavoriteDto.userUid()))
                .fetch();
    }
}
