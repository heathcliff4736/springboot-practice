package com.ssg.gallery.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String loginId;
//    private String login_id;


    @Column(length = 100, nullable = false)
    private String loginPw;
    //    private String login_pw;

    @Column(nullable = false, unique = false)
    @CreationTimestamp
    private LocalDateTime created;

    public Member() {}

    public Member(String name, String loginId, String loginPw) {
        this.name = name;
//        this.login_id = login_id;
//        this.login_pw = login_pw;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }
}
