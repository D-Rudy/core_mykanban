package com.mykanban.core.service;

import com.mykanban.core.api.model.BoardCreationRequest;
import com.mykanban.core.repository.BoardRepository;
import com.mykanban.core.repository.ColonneRepository;
import com.mykanban.core.repository.entity.Board;
import com.mykanban.core.repository.entity.Colonne;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final ColonneRepository colonneRepository;

    public BoardService(BoardRepository boardRepository, ColonneRepository colonneRepository) {
        this.boardRepository = boardRepository;
        this.colonneRepository = colonneRepository;
    }


    public Board createBoard(BoardCreationRequest boardCreationRequest) {
        return boardRepository.save(new Board(boardCreationRequest.boardName()));
    }

    public List<Colonne> getColonnesByBoard(final long id) {
        return colonneRepository.getColonneByBoard(id);
    }

    public List<Board> getBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> getBoard(final long id) {
        return boardRepository.findById(id);
    }

    public void deleteBoard(final long id) {
        boardRepository.deleteById(id);
    }
}
