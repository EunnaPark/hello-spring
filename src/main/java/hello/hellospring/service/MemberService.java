package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//implement close business logic whereas repository is close mechanism
//@Service(component scan)
public class MemberService {

    private final MemberRepository memberRepository ;

    //@Autowired(component scan)
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    //register member
    public Long join(Member member){

        //avoid member with same name
        validateDuplicateMember(member);
        //result.orElseGet() ; also good way.


        memberRepository.save(member);
        return member.getId();
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
}
