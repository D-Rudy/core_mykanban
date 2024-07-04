package com.mykanban.core.unitTest.controllerTest;

import com.mykanban.core.api.controller.BoardController;
import com.mykanban.core.api.model.BoardCreationRequest;
import com.mykanban.core.repository.entity.Board;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.service.BoardService;
import com.mykanban.core.service.ColonneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BoardControllerTest {

    @Mock
    private BoardService boardService;

    @Mock
    private ColonneService colonneService;

    @Mock
    private Logger logger;

    @InjectMocks
    private BoardController boardController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize all mocks
        boardController = new BoardController(boardService, colonneService);
    }

    @Test
    public void testCreateBoard() {
        BoardCreationRequest boardCreationRequest = new BoardCreationRequest("My Board");
        Board expectedBoard = new Board(boardCreationRequest.nomBoard());

        Mockito.when(boardService.createBoard(boardCreationRequest)).thenReturn(expectedBoard);

        Board actualBoard = boardController.createBoard(boardCreationRequest);

        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testGetBoard() {
        long boardId = 1L;
        Board expectedBoard = new Board("My Board");

        Mockito.when(boardService.getBoard(boardId)).thenReturn(Optional.of(expectedBoard));

        Board actualBoard = boardController.getBoard(boardId);

        assertEquals(expectedBoard, actualBoard);
    }

    @Test
    public void testGetBoardById_NotFound() {
        long boardId = 1L;

        Mockito.when(boardService.getBoard(boardId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> boardController.getBoard(boardId));
    }

    @Test
    public void testGetAllBoards() {
        List<Board> expectedBoards = new ArrayList<>();
        expectedBoards.add(new Board("Board 1"));
        expectedBoards.add(new Board("Board 2"));

        Mockito.when(boardService.getBoards()).thenReturn(expectedBoards);

        List<Board> actualBoards = boardController.getBoards();

        assertEquals(expectedBoards, actualBoards);
    }

    @Test
    public void testGetColonnesByBoard() {
        long boardId = 1L;
        List<Colonne> expectedColonnes = new ArrayList<>();
        expectedColonnes.add(new Colonne("Colonne 1"));
        expectedColonnes.add(new Colonne("Colonne 2"));

        Mockito.when(boardService.getColonnesByBoard(boardId)).thenReturn(expectedColonnes);

        List<Colonne> actualColonnes = boardController.getColonnesByBoard(boardId);

        assertEquals(expectedColonnes, actualColonnes);
    }

    @Test
    public void testDeleteBoard() {

        Board boardToDelete = new Board(1L);

        Mockito.when(boardService.getBoard(1L)).thenReturn(Optional.of(boardToDelete));

        boardController.deleteBoard(1L);
    }
}

