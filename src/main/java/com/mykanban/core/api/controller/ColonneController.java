package com.mykanban.core.api.controller;

import com.mykanban.core.api.exception.ColonneNotFoundException;
import com.mykanban.core.api.model.ColonneCreationRequest;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.repository.entity.Ticket;
import com.mykanban.core.service.ColonneService;
import com.mykanban.core.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colonnes")
public class ColonneController {
    Logger logger = LoggerFactory.getLogger(ColonneController.class);

    private final ColonneService colonneService;
    private final TicketService ticketService;

    public ColonneController(ColonneService colonneService, TicketService ticketService) {
        this.ticketService = ticketService;
        this.colonneService = colonneService;
    }

    @PostMapping
    public Colonne createColonne(@RequestBody ColonneCreationRequest creationRequest) {
        return colonneService.createColonne(creationRequest);
    }

    @GetMapping("/{id}")
    public Colonne getColonne(@PathVariable long id) throws ColonneNotFoundException {
        return colonneService.getColonne(id).orElseThrow(() -> new ColonneNotFoundException("Colonne not found"));
    }

    @GetMapping
    public List<Colonne> getAllColonnes() {
        return colonneService.getAllColonnes();
    }

    @GetMapping("/{id}/tickets")
    public List<Ticket> getTicketsByColonne(@PathVariable long id) {
        return ticketService.getTicketsByColonne(id);
    }

    @DeleteMapping("/{id}")
    public void deleteColonne(@PathVariable long id) throws ColonneNotFoundException {
        Colonne colonne = colonneService.getColonne(id).orElseThrow(() -> new ColonneNotFoundException("Column not found"));
        colonneService.deleteColonne(colonne.getId());
    }
}
