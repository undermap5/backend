package org.bbosiregi.demo.favorite_place.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bbosiregi.demo.favorite_place.dto.FavoritePlaceDto;
import org.bbosiregi.demo.favorite_place.dto.UserFavoriteDto;
import org.bbosiregi.demo.favorite_place.entity.FavoritePlace;
import org.bbosiregi.demo.favorite_place.service.FavoritePlaceService;
import org.bbosiregi.demo.subway_info.entity.SubwayInfo;
import org.bbosiregi.demo.user.dto.LoginDto;
import org.bbosiregi.demo.util.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
public class FavoriteController {
    private final FavoritePlaceService favoritePlaceService;
    @PutMapping("/favorite")
    public HttpResponse<?> checkFavoritePlace(@RequestBody FavoritePlaceDto favoritePlaceDto) {
        favoritePlaceService.checkFavoritePlace(favoritePlaceDto);
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",null);
    }
    @GetMapping("/favorite")
    public HttpResponse<?> getFavoritePlace(@RequestBody UserFavoriteDto userFavoriteDto) {
        List<SubwayInfo> subwayInfoList = favoritePlaceService.findFavoritePlace(userFavoriteDto);
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",subwayInfoList);
    }
}
