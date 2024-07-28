package org.bbosiregi.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="login_id")
    private String loginId;
    @Column(name="password")
    private String password;
    @Column(name="nickname")
    private String nickname;
}
