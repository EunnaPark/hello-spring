package com.hellospring.service;

import com.hellospring.repository.JpaMemberRepository;
import com.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

//@Configuration
public class SpringConfig {
    /*
        private final EntityManager em;
        private final DataSource dataSource;

        public SpringConfig(DataSource dataSource, EntityManager em){
            this.em = em;
            this.dataSource = dataSource;
        }

        @Bean
        public MemberService memberService(){

            return new MemberService(memberRepository());
        }
    @Bean
    public MemberRepository memberRepository(){

    //return new MemoryMemberRepository();
    //return new JdbcMemberRepository(dataSource);
    //return new JdbcTemplateMemberRepository(dataSource);

        return new JpaMemberRepository(em);
    }
*/
}
