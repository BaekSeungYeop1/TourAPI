package com.example.tourapi.security.service;

import com.example.tourapi.member.Member;
import com.example.tourapi.member.MemberRepository;
import com.example.tourapi.security.controller.MemberDto;
import com.example.tourapi.security.exception.DuplicateEmailException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class MemberService {

    final MemberRepository memberRepository;
    final PasswordEncoder passwordEncoder;

    @Transactional
    public void saveMember(MemberDto memberDto) throws Exception {
        validateDuplicateEmail(memberDto.getEmail());
        memberRepository.save(Member.createMember(
                memberDto.getEmail(),
                passwordEncoder.encode(memberDto.getPassword()),
                memberDto.getNickname()));
    }

    private void validateDuplicateEmail(String email) throws Exception{
        if(memberRepository.existsByEmail(email)){
            throw new DuplicateEmailException();
        }
    }

}
