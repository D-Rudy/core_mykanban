package com.mykanban.core.api;

import com.mykanban.core.api.exception.BoardNotFoundException;
import com.mykanban.core.api.exception.ColonneNotFoundException;
import com.mykanban.core.api.exception.TicketNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler({BoardNotFoundException.class, ColonneNotFoundException.class, TicketNotFoundException.class})
    public ResponseEntity<String> handleBoardNotFoundException(BoardNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

