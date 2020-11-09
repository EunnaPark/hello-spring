package com.board.repository;


import com.board.domain.Board;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface BoardRepository {
    Board save(Board member); //insertBoard(BoardDTO params)
    Optional<Board> findById(Long Id);// selectBoardDetail
    Optional<Board> findByName (String name); //selectBoardDetail
    List<Board> findAll();  //selectBoardList
    int deleteById(Long id); //public int deleteBoard(Long idx);
    int selectBoardTotalCount();
}
