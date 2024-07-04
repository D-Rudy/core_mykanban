package com.mykanban.core.unitTest.serviceTest;

import com.mykanban.core.api.model.BoardCreationRequest;
import com.mykanban.core.repository.BoardRepository;
import com.mykanban.core.repository.ColonneRepository;
import com.mykanban.core.repository.entity.Board;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.service.BoardService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @Mock
    private ColonneRepository colonneRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    public void testCreateBoard() {
        BoardCreationRequest boardCreationRequest = new BoardCreationRequest("My Test Board");

        ArgumentCaptor<Board> boardCaptor = ArgumentCaptor.forClass(Board.class);
        Mockito.when(boardRepository.save(boardCaptor.capture())).thenReturn(null); // Don't return a specific object

        Board actualBoard = boardService.createBoard(boardCreationRequest);

        Board capturedBoard = boardCaptor.getValue();
        assertEquals("My Test Board", capturedBoard.getNom()); // Assert on captured board properties
        // Assert other expected properties if needed
    }

    @Test
    public void testGetBoards() {
        List<Board> expectedBoards = new ArrayList<>();
        expectedBoards.add(new Board("Board 1"));
        expectedBoards.add(new Board("Board 2"));

        Mockito.when(boardRepository.findAll()).thenReturn(expectedBoards);

        List<Board> actualBoards = boardService.getBoards();

        assertEquals(expectedBoards, actualBoards);
    }

    @Test
    public void testGetBoard_success() {
        long boardId = 1L;
        Board expectedBoard = new Board("Existing Board");

        Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.of(expectedBoard));

        Optional<Board> actualBoard = boardService.getBoard(boardId);

        assertTrue(actualBoard.isPresent());
        assertEquals(expectedBoard, actualBoard.get());
    }

    @Test
    public void testGetBoard_notFound() {
        long boardId = 1L;

        Mockito.when(boardRepository.findById(boardId)).thenReturn(Optional.empty());

        Optional<Board> actualBoard = boardService.getBoard(boardId);

        assertFalse(actualBoard.isPresent());
    }

    @Test
    public void testDeleteBoard() {
        long boardId = 1L;

        // Simulate successful deletion (no return value for void methods)
        doNothing().when(boardRepository).deleteById(boardId);

        boardService.deleteBoard(boardId);

        verify(boardRepository, times(1)).deleteById(boardId);
    }
    @Test
    public void testGetColonnesByBoard() {
        long boardId = 1L;
        List<Colonne> expectedColonnes = Arrays.asList(new Colonne("Colonne 1"), new Colonne("Colonne 2"));

        Mockito.when(colonneRepository.getColonneByBoard(boardId)).thenReturn(expectedColonnes);

        List<Colonne> actualColonnes = boardService.getColonnesByBoard(boardId);

        assertEquals(expectedColonnes, actualColonnes);
    }

}