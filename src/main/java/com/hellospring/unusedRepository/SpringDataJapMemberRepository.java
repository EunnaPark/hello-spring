package com.hellospring.unusedRepository;

import com.hellospring.domain.Member;
import com.hellospring.repository.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJapMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);

    @Override
    void deleteById(Long id);
}
