package org.bbosiregi.demo.subway_info.service;

import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.subway_info.dto.SubwayInfoDto;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.subway_info.repository.SubwayInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubwayInfoService {
    private final SubwayInfoRepository subwayInfoRepository;

    public List<SubwayInfo> getAllStation() {
        return subwayInfoRepository.findAll();
    }
}
