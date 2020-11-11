package com.hellospring.service;

import com.hellospring.domain.Member;
import com.hellospring.unusedRepository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class MemberServiceTest {
    @InjectMocks
    MemberService memberService;
    @Mock
    MemoryMemberRepository memberRepository;



    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository); //dependence injection
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void duplicateMember(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //then
        //1) not good with try-catch
//        try {
//            memberService.join(member2);
//            fail();
//        }catch(IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("already exisiting");
//        }
        //2 better way
        Exception e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("already exisiting");

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }

    @ExtendWith(MockitoExtension.class)
    void deleteById() {
        //given
        Long Id = Long.valueOf(1);
        memberService.deleteById(Id);

        verify(memberRepository, times(1)).deleteById(eq(Id));

    }
}