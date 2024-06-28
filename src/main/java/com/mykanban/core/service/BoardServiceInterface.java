package com.mykanban.core.service;

import com.mykanban.core.model.Board;

public interface BoardServiceInterface {
    void createBoard(Board board);
    Iterable<Board> getBoards();
    Board getBoard(long id);
}
