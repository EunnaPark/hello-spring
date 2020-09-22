package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    private EntityManager em;
//    public SpringConfig(EntityManager em){
//        this.em = em;
//    }
//    @Bean
//    public MemberService memberService(){
//
//        return new MemberService(memberRepository());
//    }
//    @Bean
//    public MemberRepository memberRepository(){

    //return new MemoryMemberRepository();
    //return new JdbcMemberRepository(dataSource);
    //return new JdbcTemplateMemberRepository(dataSource);

    //return new JpaMemberRepository(em);
//    }

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }
    /*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/


}
