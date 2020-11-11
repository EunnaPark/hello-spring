package com.board.repository;

import com.board.domain.Board;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Component
@Repository
public class JpaBoardRepository implements BoardRepository {

    private final EntityManager em; //JPA works with it.
    public JpaBoardRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public Board save(Board board) {

        if(board.getIdx() != null) {
            Board newBoard = em.find(Board.class, board.getIdx());
            em.getTransaction().begin();
            newBoard.setContents(board.getContents());
            newBoard.setTitle(board.getTitle());
            newBoard.setDeleteYn(board.getDeleteYn());
            newBoard.setNoticeYn(board.getNoticeYn());
            newBoard.setSecretYn(board.getSecretYn());
            em.getTransaction().commit();

        }else{

            em.persist(board);
        }
        return board;
    }

    @Override
    public Optional<Board> findById(Long Id) {
        Board board = em.find(Board.class, Id);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findByName(String contents) {
        List<Board> result =  em.createQuery("select m from Board m where m.contents like :contents %", Board.class)
                .setParameter(contents, contents)
                .getResultList();
        return result.stream().findAny();

    }

    @Override
    public List<Board> findAll() {
        return em.createQuery("select m from Board m", Board.class).getResultList();
    }

    @Override
    public int deleteById(Long id) {
        return em.createQuery("delete from Board m where m.Idx = :id", Board.class).getFirstResult();
    }

    @Override
    public int selectBoardTotalCount(){
         return ((Number)em.createQuery("select count(e) from Board e")
                .getSingleResult()).intValue();
    }

}
