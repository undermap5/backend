package org.bbosiregi.demo.user.service;

import lombok.RequiredArgsConstructor;
import org.bbosiregi.demo.user.dto.LoginDto;
import org.bbosiregi.demo.user.dto.SignUpDto;
import org.bbosiregi.demo.user.entity.Users;
import org.bbosiregi.demo.user.repository.UserRepository;
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

    public String login(LoginDto loginDto) throws Exception {
        Users users = userRepository.findByUid();
        if (!users.getLoginId().equals(loginDto.loginId())) throw new Exception("login id 불일치");
        if (!users.getPassword().equals(loginDto.password())) throw new Exception("비밀번호 불일치");
        return users.getUid();
    }
}
