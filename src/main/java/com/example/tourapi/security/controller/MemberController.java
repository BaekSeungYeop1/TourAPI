package com.example.tourapi.security.controller;

import com.example.tourapi.member.Member;
import com.example.tourapi.member.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    final MemberRepository memberRepository;
    final PasswordEncoder passwordEncoder;

    @PostMapping("/api/member")
    public String saveMember(@RequestBody MemberDto memberDto){
        memberRepository.save(Member.createMember(memberDto.getEmail(),
                passwordEncoder.encode(memberDto.getPassword())));
        return "success";
    }
}

@Data
class MemberDto{
    private String email;
    private String password;
}
