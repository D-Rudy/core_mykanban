package com.mykanban.core.api.controller;

import com.mykanban.core.api.exception.TicketNotFoundException;
import com.mykanban.core.api.model.TicketCreationRequest;
import com.mykanban.core.repository.entity.Ticket;
import com.mykanban.core.service.TicketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public Ticket createColonne(@RequestBody TicketCreationRequest creationRequest) {
        return ticketService.createTicket(creationRequest);
    }

    @GetMapping("{id}")
    public Optional<Ticket> getTicket(@PathVariable("id") long id) throws TicketNotFoundException {
        return Optional.ofNullable(ticketService.getTicket(id).orElseThrow(() -> new TicketNotFoundException("Ticket not found")));
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getTickets();
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable("id") long id) {
        ticketService.deleteTicket(id);
    }
}
