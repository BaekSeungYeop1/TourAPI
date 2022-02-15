package com.example.tourapi.security.service;

import com.example.tourapi.member.Member;
import com.example.tourapi.member.MemberRepository;
import com.example.tourapi.security.controller.MemberDto;
import com.example.tourapi.security.exception.DuplicateEmailException;
import com.example.tourapi.security.exception.DuplicateNicknameException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService {

    final MemberRepository memberRepository;
    final PasswordEncoder passwordEncoder;

    @Transactional
    public void saveMember(MemberDto memberDto) throws Exception {
        validateDuplicateEmail(memberDto.getEmail(),memberDto.getNickname());

        memberRepository.save(Member.createMember(
                memberDto.getEmail(),
                passwordEncoder.encode(memberDto.getPassword()),
                memberDto.getNickname()));
    }

    private void validateDuplicateEmail(String email,String nickname) {
        //log.info("nickname = " + nickname);
        if(memberRepository.existsByEmail(email)){
            throw new DuplicateEmailException();
        }
        if(memberRepository.existsByNickname(nickname)){
            throw new DuplicateNicknameException();
        }
    }

}
