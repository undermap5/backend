package org.bbosiregi.demo.subway_info.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bbosiregi.demo.subway_info.dto.SearchDto;
import org.bbosiregi.demo.subway_info.dto.SubwayInfoDto;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.subway_info.service.SubwayInfoService;
import org.bbosiregi.demo.util.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @PostMapping("/subway/search")
    public HttpResponse<?> findStation(@RequestBody SearchDto searchDto) {
        List<String> stationList = new ArrayList<>();

        String from = searchDto.from();
        String to = searchDto.to();

        switch (from + "->" + to) {
            case "V14->V15":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("V9");
                stationList.add("V14");
                break;
            case "V15->V14":
                stationList.add("V14");
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->L5":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                break;
            case "L5->V15":
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->L4":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                break;
            case "L4->V15":
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->L21":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("R10");
                stationList.add("V12");
                stationList.add("V13");
                stationList.add("R11");
                break;
            case "L21->V15":
                stationList.add("R11");
                stationList.add("V13");
                stationList.add("V12");
                stationList.add("R10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->L22":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("V10");
                stationList.add("V11");
                break;
            case "L22->V15":
                stationList.add("V11");
                stationList.add("V10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->T1":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                break;
            case "T1->V15":
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->T2":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                break;
            case "T2->V15":
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V15->T3":
                stationList.add("V1");
                stationList.add("V2");
                stationList.add("V3");
                stationList.add("R1");
                stationList.add("R2");
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                break;
            case "T3->V15":
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                stationList.add("R2");
                stationList.add("R1");
                stationList.add("V3");
                stationList.add("V2");
                stationList.add("V1");
                break;
            case "V14->L5":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->V14":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->L4":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L4->V14":
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->L21":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("R10");
                stationList.add("V12");
                stationList.add("V13");
                break;
            case "L21->V14":
                stationList.add("V13");
                stationList.add("V12");
                stationList.add("R10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->L22":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("V10");
                stationList.add("V11");
                break;
            case "L22->V14":
                stationList.add("V11");
                stationList.add("V10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->T1":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                break;
            case "T1->V14":
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->T2":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                break;
            case "T2->V14":
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "V14->T3":
                stationList.add("V9");
                stationList.add("R8");
                stationList.add("R9");
                break;
            case "T3->V14":
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("V9");
                break;
            case "L5->L4":
                stationList.add("V4");
                stationList.add("V5");
                break;
            case "L4->L5":
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->L21":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("R10");
                stationList.add("V12");
                stationList.add("V13");
                break;
            case "L21->L5":
                stationList.add("V13");
                stationList.add("V12");
                stationList.add("R10");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R9");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->L22":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("V10");
                stationList.add("V11");
                break;
            case "L22->L5":
                stationList.add("V11");
                stationList.add("V10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->T1":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                break;
            case "T1->L5":
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->T2":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                break;
            case "T2->L5":
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L5->T3":
                stationList.add("V4");
                stationList.add("V5");
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                break;
            case "T3->L5":
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                stationList.add("V5");
                stationList.add("V4");
                break;
            case "L4->L21":
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("R10");
                stationList.add("V12");
                stationList.add("V13");
                break;
            case "L21->L4":
                stationList.add("V13");
                stationList.add("V12");
                stationList.add("R10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L4->L22":
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                stationList.add("V10");
                stationList.add("V11");
                break;
            case "L22->L4":
                stationList.add("V11");
                stationList.add("V10");
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L4->T1":
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                break;
            case "T1->L4":
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L4->T2":
                stationList.add("V6");
                stationList.add("V7");
                break;
            case "T2->L4":
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L4->T3":
                stationList.add("V6");
                stationList.add("V7");
                stationList.add("V8");
                stationList.add("R4");
                stationList.add("R5");
                stationList.add("R6");
                stationList.add("R7");
                stationList.add("R8");
                stationList.add("R9");
                break;
            case "T3->L4":
                stationList.add("R9");
                stationList.add("R8");
                stationList.add("R7");
                stationList.add("R6");
                stationList.add("R5");
                stationList.add("R4");
                stationList.add("V8");
                stationList.add("V7");
                stationList.add("V6");
                break;
            case "L21->L22":
                stationList.add("V13");
                stationList.add("V12");
                stationList.add("R10");
                stationList.add("R9");
                stationList.add("V10");
                stationList.add("V11");
                break;
            case "L22->L21":
                stationList.add("V11");
                stationList.add("V10");
                stationList.add("R9");
                stationList.add("R10");
                stationList.add("V12");
                stationList.add("V13");
                break;
        }
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",stationList);
    }
}
