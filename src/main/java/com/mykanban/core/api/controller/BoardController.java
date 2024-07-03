package com.mykanban.core.api.controller;

import com.mykanban.core.api.model.BoardCreationRequest;
import com.mykanban.core.repository.entity.Board;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.service.BoardService;
import com.mykanban.core.service.ColonneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {


    Logger logger = LoggerFactory.getLogger(BoardController.class);

    private final BoardService boardService;
    private final ColonneService colonneService;

    public BoardController(BoardService boardService, ColonneService colonneService) {
        this.boardService = boardService;
        this.colonneService = colonneService;
    }

    @PostMapping
    public Board createBoard(@RequestBody BoardCreationRequest boardCreationRequest) {
        return boardService.createBoard(boardCreationRequest);
    }

    @GetMapping("/{id}")
    public Board getBoard(@PathVariable long id) {
        return boardService.getBoard(id).orElseThrow();
    }

    @GetMapping
    public List<Board> getBoards() {
        return boardService.getBoards();
    }

    @GetMapping("/{id}/colonnes")
    public List<Colonne> getColonnesByBoard(@PathVariable long id) {
        return boardService.getColonnesByBoard(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable long id) {
        Board board = boardService.getBoard(id).orElseThrow(() -> new RuntimeException("Board not found"));
        List<Colonne> colonnes = boardService.getColonnesByBoard(id);
        for (Colonne colonne : colonnes) {
            colonneService.deleteColonne(colonne.getId());
        }

        boardService.deleteBoard(board.getId());

    }


}