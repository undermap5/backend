package org.bbosiregi.demo.favorite_place.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bbosiregi.demo.favorite_place.dto.FavoritePlaceDto;
import org.bbosiregi.demo.favorite_place.entity.FavoritePlace;
import org.bbosiregi.demo.favorite_place.service.FavoritePlaceService;
import org.bbosiregi.demo.user.dto.LoginDto;
import org.bbosiregi.demo.util.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/favorite")
public class FavoriteController {
    private final FavoritePlaceService favoritePlaceService;
    @PutMapping
    public HttpResponse<?> checkFavoritePlace(@RequestBody FavoritePlaceDto favoritePlaceDto) {
        favoritePlaceService.checkFavoritePlace(favoritePlaceDto);
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",null);
    }
}
