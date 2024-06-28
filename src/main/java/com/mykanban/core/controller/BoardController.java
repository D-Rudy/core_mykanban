package com.mykanban.core.controller;

import com.mykanban.core.model.Board;
import com.mykanban.core.service.BoardServiceInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceInterface boardService;

    public BoardController(BoardServiceInterface boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create")
    public String createBoard(String nom) {

        Board board = new Board();
        board.setNom(nom);

        boardService.createBoard(board);

        return "board-created";
    }

    @GetMapping("/boards")
    public Iterable<Board> list() {
        Iterable<Board> boards = boardService.getBoards();
        boards.forEach(board -> {
                    System.out.println(board.toString());
                }
        );
        return boards;
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable int id) {
        return boardService.getBoard(id);
    }
}
