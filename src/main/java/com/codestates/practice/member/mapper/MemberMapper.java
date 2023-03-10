package com.codestates.practice.member.mapper;

import com.codestates.practice.member.dto.MemberPatchDto;
import com.codestates.practice.member.dto.MemberPostDto;
import com.codestates.practice.member.dto.MemberResponseDto;
import com.codestates.practice.member.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponseDto(Member member);
    List<MemberResponseDto> membersToMemberResponseDto(List<Member> members);
}
