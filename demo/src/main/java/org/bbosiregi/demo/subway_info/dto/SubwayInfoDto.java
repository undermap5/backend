package org.bbosiregi.demo.subway_info.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SubwayInfoDto {
    Long stationId;
    String StationName;
}
