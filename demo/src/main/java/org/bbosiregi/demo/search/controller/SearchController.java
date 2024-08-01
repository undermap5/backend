//package org.bbosiregi.demo.search.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.bbosiregi.demo.search.dto.SearchRequest;
//import org.bbosiregi.demo.search.dto.SearchResponse;
//import org.bbosiregi.demo.search.service.SearchService;
//import org.bbosiregi.demo.util.HttpResponse;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@RequestMapping("/api/v1/search")
//public class SearchController {
//    private SearchService searchService;
//    @GetMapping
//    public HttpResponse<?> getSearchStation() {
//        List<SearchResponse> stationList = searchService.getAllSation();
//        return new HttpResponse<>(HttpStatus.OK,"Successful Access",stationList);
//    }
//}
