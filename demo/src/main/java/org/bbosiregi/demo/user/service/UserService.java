package org.bbosiregi.demo.user.service;

import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.user.dto.LoginDto;
import org.bbosiregi.demo.user.dto.SignUpDto;
import org.bbosiregi.demo.user.entity.Users;
import org.bbosiregi.demo.user.repository.UserRepository;
import org.bbosiregi.demo.util.error.ErrorCode;
import org.bbosiregi.demo.util.error.handler.BusinessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void signUp(SignUpDto signUpDto) {
        Users users = Users.builder()
                .loginId(signUpDto.loginId())
                .password(signUpDto.password())
                .nickname(signUpDto.nickname())
                .uid(UUID.randomUUID().toString())
                .build();
        userRepository.save(users);
    }

    public void login(LoginDto loginDto) {
        Users users = userRepository.findByLoginIdAndPassword(
                loginDto.loginId(),
                loginDto.password()
        ).orElseThrow(() -> new BusinessException(ErrorCode.BAD_REQUEST));
    }

}
