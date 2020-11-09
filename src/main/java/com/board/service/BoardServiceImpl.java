package com.board.service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.board.domain.Board;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImpl implements BoardService{

        @Autowired
        private BoardRepository boardRepository;

        @Override
        public boolean registerBoard(Board board) {
            boardRepository.save(board);
            return (board.getIdx() != null) ? true : false;
        }

        @Override
        public List<Board> getBoardDetail(Long idx) {
            Board board = new Board();
            Optional<Board> opList = boardRepository.findById(idx);
            List<Board> list = opList.stream().collect(Collectors.toList());
            return list;

        }

        @Override
        public boolean deleteBoard(Long idx) {
            int queryResult = 0;

            Optional<Board> board = boardRepository.findById(idx);

            if (board != null && "N".equals(board.orElseGet(Board::new).getDeleteYn())) {
                queryResult = boardRepository.deleteById(idx);
            }

            return (queryResult == 1) ? true : false;
        }

        @Override
        public List<Board> getBoardList() {

            int boardTotalCount = boardRepository.selectBoardTotalCount();
            List<Board> boardList = Collections.emptyList();

            if (boardTotalCount > 0) {
                boardList = boardRepository.findAll();
            }

            return boardList;
        }

}

