package com.hellospring.service;

import com.hellospring.domain.Member;
import com.hellospring.repository.MemberRepository;
//import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//implement close business logic whereas repository is close mechanism
@Service//(component scan)
//@Transactional // if need to use JPA, transactional is necessary.
public class MemberService {

    private final MemberRepository memberRepository ;

    @Autowired//(component scan)
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //register member
    public Long join(Member member){
        long start = System.currentTimeMillis();

        try{
            //avoid member with same name
            validateDuplicateMember(member);
            //result.orElseGet() ; also good way.
            memberRepository.save(member);
            return member.getId();
        }finally{
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join >> " + timeMs +"ms");
        }

    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException(("already exisiting"));
                });
    }


    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id){
        return memberRepository.findById(id);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    public void updateById(Member member) {
        memberRepository.save(member);
    }
}
