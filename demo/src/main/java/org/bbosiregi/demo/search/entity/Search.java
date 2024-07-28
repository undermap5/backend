package org.bbosiregi.demo.search.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bbosiregi.demo.location.entity.Location;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="search")
public class Search {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subway_info_id")
    private SubwayInfo subwayInfo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;
}
