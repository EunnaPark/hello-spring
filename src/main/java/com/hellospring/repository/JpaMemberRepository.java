package com.hellospring.repository;

import com.board.domain.Board;
import com.hellospring.domain.Member;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;



public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //JPA works with it.
    public JpaMemberRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Member save(Member member) {

        Member updateMember = em.find(Member.class, member.getId());
        if(member.getId() != null) {
            em.getTransaction().begin();
            updateMember.setName(member.getName());
            updateMember.setSalary(member.getSalary());
            em.getTransaction().commit();
        }else{
            em.persist(member);
        }

        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        Member member = em.find(Member.class, Id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result =  em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    @Override
    public void deleteById(Long Id) {
        em.createQuery("delete from Member m where m.Id = :Id", Member.class).getFirstResult();
    }

}
