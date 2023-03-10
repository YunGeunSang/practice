package com.codestates.practice.member.repository;

import com.codestates.practice.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MemberRepository extends CrudRepository<Member, Long>{
    Optional<Member> findByEmail(String email);
}
