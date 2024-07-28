package org.bbosiregi.demo.location.entity;

import jakarta.persistence.*;
import lombok.*;
import org.bbosiregi.demo.mark_floor_info.entity.MarkFloorInfo;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="lng")
    private Double lng;
    @Column(name="lat")
    private Double lat;
    @Column(name="geo")
    private String geo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mark_floor_info")
    private MarkFloorInfo markFloorInfo;
}
