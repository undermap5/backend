package org.bbosiregi.demo.search.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/search")
public class SearchController {
//    private SearchService searchService;
//    @GetMapping
//    public HttpResponse<?> getSearchStation() {
//        List<SearchResponse> stationList = searchService.getAllStation();
//        return new HttpResponse<>(HttpStatus.OK,"Successful Access",stationList);
//    }
}
