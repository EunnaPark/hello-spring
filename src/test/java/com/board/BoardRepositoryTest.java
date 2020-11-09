package com.board;

import com.board.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SpringBootTest
@ActiveProfiles("test")
@Transactional
@Rollback
public class BoardRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testOfInsert() {
        Board board = new Board();
        board.setTitle("the first title");
        board.setContents("the first contents");
        board.setWriter("the first user");
        board.setNoticeYn("Y");
        board.setDeleteYn("N");
        board.setSecretYn("N");
        board.setViewCnt(0);

        em.persist(board);
        System.out.println("the result " + board.getTitle() + ".");
    }

}
