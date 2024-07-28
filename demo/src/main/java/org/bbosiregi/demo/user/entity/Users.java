package org.bbosiregi.demo.user.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="login_id")
    private String loginId;
    @Column(name="password")
    private String password;
    @Column(name="nickname")
    private String nickname;
    @Column(name="uid")
    private String uid;
}
