package com.mykanban.core.service;

import com.mykanban.core.api.model.ColonneCreationRequest;
import com.mykanban.core.repository.ColonneRepository;
import com.mykanban.core.repository.TicketRepository;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.repository.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColonneService {

    private final ColonneRepository colonneRepository;
    private final TicketRepository ticketRepository;

    public ColonneService(ColonneRepository colonneRepository, TicketRepository ticketRepository) {
        this.colonneRepository = colonneRepository;
        this.ticketRepository = ticketRepository;
    }

    public Colonne createColonne(ColonneCreationRequest colonneCreationRequest) {
        return colonneRepository.save(new Colonne(colonneCreationRequest.colonneName()));
    }

    public Optional<Colonne> getColonne(final long id) {
        return colonneRepository.findById(id);
    }

    public List<Colonne> getAllColonnes() {
        return colonneRepository.findAll();
    }

    public void deleteColonne(final long id) {
        List<Ticket> tickets = ticketRepository.findTicketsByColonne(id);
        ticketRepository.deleteAll(tickets);
        colonneRepository.deleteById(id);
    }
}
