package org.bbosiregi.demo.user.controller;

import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.user.dto.LoginDto;
import org.bbosiregi.demo.user.dto.LoginResponseDto;
import org.bbosiregi.demo.user.dto.SignUpDto;
import org.bbosiregi.demo.user.service.UserService;

import org.bbosiregi.demo.util.HttpResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/signup")
    public HttpResponse<?> signup(@RequestBody SignUpDto signUpDto) {
        userService.signUp(signUpDto);
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",null);
    }

    @PostMapping("/login")
    public HttpResponse<?> login(@RequestBody LoginDto loginDto) throws Exception {
//        String uid = userService.login(loginDto);
//        LoginResponseDto response = LoginResponseDto.from(uid);
        return new HttpResponse<>(HttpStatus.OK,"Successful Access",null);
    }
}