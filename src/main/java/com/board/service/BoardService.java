package com.board.service;


import java.util.List;

import com.board.domain.Board;

public interface BoardService {

    public boolean registerBoard(Board params);

    public List<Board> getBoardDetail(Long idx);

    public boolean deleteBoard(Long idx);

    public List<Board> getBoardList();

}