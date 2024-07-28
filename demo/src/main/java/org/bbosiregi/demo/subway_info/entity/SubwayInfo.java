package org.bbosiregi.demo.subway_info.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="subway_info")
public class SubwayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subway_name")
    private String subwayName;
    @Column(name="subway_info", columnDefinition = "TEXT")
    private String subwayInfo;
}
