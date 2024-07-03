package com.mykanban.core.service;

import com.mykanban.core.api.model.TicketCreationRequest;
import com.mykanban.core.repository.TicketRepository;
import com.mykanban.core.repository.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public Ticket createTicket(TicketCreationRequest ticketCreationRequest) {
        return ticketRepository.save(new Ticket(ticketCreationRequest.titre(), ticketCreationRequest.description()));
    }

    public Optional<Ticket> getTicket(long id) {
        return ticketRepository.findById(id);
    }

    public List<Ticket> getTickets() {
        return ticketRepository.findAll();
    }

    public List<Ticket> getTicketsByColonne(long id) {
        return ticketRepository.findTicketsByColonne(id);
    }

    public void deleteTicket(long id) {
        ticketRepository.deleteById(id);
    }
}
