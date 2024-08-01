package org.bbosiregi.demo.subway_info.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bbosiregi.demo.subway_info.dto.SubwayInfoDto;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.subway_info.service.SubwayInfoService;
import org.bbosiregi.demo.util.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class SubwayInfoController {
    private final SubwayInfoService subwayInfoService;
    @GetMapping("/subway")
    public HttpResponse<?> getSearchStation() {
        List<SubwayInfo> stationList = subwayInfoService.getAllStation();
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",stationList);
    }
}
