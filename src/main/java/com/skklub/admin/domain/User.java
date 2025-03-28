package com.skklub.admin.domain;

import com.skklub.admin.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(exclude = "id", callSuper = false)
public class User extends BaseTimeEntity {
    @Id @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
    private String name;
    private String contact;

    public User(String username, String password, Role role, String name, String contact) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.contact = contact;
    }

    public void update(User updateInfo) {
        this.password = updateInfo.password;
        this.name = updateInfo.name;
        this.contact = updateInfo.contact;
    }

    public void encodePw(String encodedPw) {
        this.password = encodedPw;
    }
}
