package com.hellospring.repository;

import com.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long Id);// if there are no value, java 8
    Optional<Member> findByName (String name);
    List<Member> findAll();
    void deleteById(Long id);
}
