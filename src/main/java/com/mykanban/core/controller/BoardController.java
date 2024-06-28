package com.mykanban.core.controller;

import com.mykanban.core.model.Board;
import com.mykanban.core.service.BoardServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {
    Logger logger = LoggerFactory.getLogger(BoardController.class);
    private final BoardServiceInterface boardService;

    public BoardController(BoardServiceInterface boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/create/{nom}")
    public Board createBoard(@PathVariable String nom) {
        Board board = new Board();
        board.setNom(nom);
        boardService.createBoard(board);
        logger.info("Board créé");
        return board;
    }

    @GetMapping("/boards")
    public Iterable<Board> list() {
        Iterable<Board> boards = boardService.getBoards();
        logger.info("Boards trouvés");
        return boards;
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable int id) {
        logger.info("Board {%d} trouvé", id);
        return boardService.getBoard(id);
    }
}
