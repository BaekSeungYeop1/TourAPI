package com.example.tourapi.security.controller;

import lombok.Data;

@Data
public class MemberDto {
    private String email;
    private String password;
    private String nickname;
}
