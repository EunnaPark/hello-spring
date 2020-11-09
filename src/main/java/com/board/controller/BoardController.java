package com.board.controller;

import com.board.domain.Board;
import com.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping(value = "/board")
    public String getBoardList(Model model) {
        List<Board> boardList = boardService.getBoardList();

        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @PostMapping(value = "/board/insert")
    public String registerBoard(Board board, Model model) {

        board.setUpdateTime(LocalDateTime.now());
        board.setDeleteYn(board.getDeleteYn() == null? "N":"Y");
        board.setNoticeYn(board.getNoticeYn() == null? "N":"Y");
        board.setSecretYn(board.getSecretYn() == null? "N":"Y");

        boardService.registerBoard(board);
        List<Board> boardList = boardService.getBoardList();
        model.addAttribute("boardList", boardList);
        return "redirect:";
    }

    @GetMapping(value = "/board/write")
    public String newBoard(Board board, Model model) {
        board.setUpdateTime(LocalDateTime.now());

        return "board/write";
    }

    @GetMapping(value = "/board/delete")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        boolean bResult = boardService.deleteBoard(idx);
        List<Board> boardList;
        if(bResult == true) {
            boardList = boardService.getBoardList();
            model.addAttribute("boardList", boardList);
        }else{
            model.addAttribute("boardList", "Error");
        }

        return "board/list";
    }

    @GetMapping(value = "/board/view")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        if (idx == null) {
            return "redirect:";
        }

        List<Board> board = boardService.getBoardDetail(idx);
        if (board.isEmpty() == true || board == null) {
             return "redirect:";
        }
        model.addAttribute("board", board.get(0));

        return "board/view";
    }

}