package org.bbosiregi.demo.subway_info.repository;

import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubwayInfoRepository extends JpaRepository<SubwayInfo, Long> {
}
