package com.codestates.practice.member.mapper;

import com.codestates.practice.member.dto.MemberPatchDto;
import com.codestates.practice.member.dto.MemberPostDto;
import com.codestates.practice.member.entity.Member;
import com.codestates.practice.member.entity.MemberResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public Member memberPostDtoToMember(MemberPostDto memberPostDto){
        return new Member(0L, memberPostDto.getEmail(), memberPostDto.getName(), memberPostDto.getPhone());
    }

    public Member memberPatchDtoToMember(MemberPatchDto memberPatchDto){
        return new Member(memberPatchDto.getMemberId(), null, memberPatchDto.getName(), memberPatchDto.getPhone());
    }

    public MemberResponseDto memberToMemberResponseDto(Member member){
        return new MemberResponseDto(member.getMemberId(),
                member.getEmail(),
                member.getName(),
                member.getPhone());
    }
}

