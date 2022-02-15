package com.example.tourapi.security.controller;


import com.example.tourapi.security.service.MemberService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {


    final MemberService memberService;
    final PasswordEncoder passwordEncoder;

    @PostMapping("/api/member")
    public String saveMember(@RequestBody @Valid MemberDto memberDto) throws Exception{
        memberService.saveMember(memberDto);
        return "success";
    }

}

