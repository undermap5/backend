package org.bbosiregi.demo.favorite_place.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bbosiregi.demo.location.entity.Location;
import org.bbosiregi.demo.search.entity.Search;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.user.entity.Users;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="favorite_place")
public class FavoritePlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subwayInfo_id")
    private SubwayInfo subwayInfo;
}
