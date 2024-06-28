package com.mykanban.core.service;

import com.mykanban.core.model.Board;
import com.mykanban.core.repository.BoardRepositoryInterface;
import org.springframework.stereotype.Service;

@Service
public class BoardService implements BoardServiceInterface {

    private final BoardRepositoryInterface boardRepository;

    public BoardService(BoardRepositoryInterface boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public Iterable<Board> getBoards() {
        return boardRepository.findAll();
    }

    @Override
    public Board getBoard(long id) {
        return boardRepository.findById(id).orElseThrow();
    }
}
