package com.codestates.practice.member.service;

import com.codestates.practice.exception.BusinessLogicException;
import com.codestates.practice.exception.ExceptionCode;
import com.codestates.practice.member.entity.Member;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MemberService {
    public Member createMember(Member member){
        Member createdMember = member;

        return createdMember;
    }

    public Member updateMember(Member member){
        Member updatedMember = member;

        return updatedMember;
    }

    public Member findMember(long memberId){
        Member member = new Member(memberId, "hdg@gmail.com", "홍길동", "010-1111-2222");

        return member;
    }

    public List<Member> findMembers(){
        List<Member> members = List.of(
                new Member(1, "hdg@gmail.com", "홍길동", "010-1111-2222"),
                new Member(2, "hdg@gmail.com", "홍길동", "010-1111-2222")
        );

        return members;
    }

    public void deleteMember(long memberId){

    }

}
