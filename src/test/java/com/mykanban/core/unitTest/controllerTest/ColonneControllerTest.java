package com.mykanban.core.unitTest.controllerTest;

import com.mykanban.core.api.controller.ColonneController;
import com.mykanban.core.api.exception.ColonneNotFoundException;
import com.mykanban.core.api.model.ColonneCreationRequest;
import com.mykanban.core.repository.entity.Colonne;
import com.mykanban.core.repository.entity.Ticket;
import com.mykanban.core.service.ColonneService;
import com.mykanban.core.service.TicketService;
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

public class ColonneControllerTest {
    @Mock
    private TicketService ticketService;

    @Mock
    private ColonneService colonneService;

    @Mock
    private Logger logger;

    @InjectMocks
    private ColonneController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new ColonneController(colonneService, ticketService);
    }

    @Test
    public void testCreateColonne() {
        ColonneCreationRequest creationRequest = new ColonneCreationRequest("Ma Colonne");
        Colonne expectedColonne = new Colonne(creationRequest.colonneName());

        Mockito.when(colonneService.createColonne(Mockito.any())).thenReturn(expectedColonne);
        Colonne actualColonne = controller.createColonne(creationRequest);

        assertEquals(expectedColonne, actualColonne);
    }

    @Test
    public void testGetColumn() throws ColonneNotFoundException {
        long colonneId = 1L;
        Colonne expectedColonne = new Colonne("Ma Colonne");

        Mockito.when(colonneService.getColonne(colonneId)).thenReturn(Optional.of(expectedColonne));

        Colonne actualColonne = controller.getColonne(colonneId);

        assertEquals(expectedColonne, actualColonne);

    }

    @Test
    public void testGetColumnNotFound() throws ColonneNotFoundException {
        long colonneId = 1L;
        Mockito.when(colonneService.getColonne(colonneId)).thenReturn(Optional.empty());
        assertThrows(ColonneNotFoundException.class, () -> controller.getColonne(colonneId));
    }

    @Test
    public void testGetColonnes() {
        List<Colonne> expectedColonnes = new ArrayList<>();
        expectedColonnes.add(new Colonne("Colonne 1"));
        expectedColonnes.add(new Colonne("Colonne 2"));

        Mockito.when(colonneService.getAllColonnes()).thenReturn(expectedColonnes);

        List<Colonne> actualColonnes = controller.getAllColonnes();
        assertEquals(expectedColonnes, actualColonnes);
    }

    @Test
    public void testGetTicketsByColonne() throws ColonneNotFoundException {
        long colonneId = 1L;
        List<Ticket> expectedTickets = new ArrayList<>();
        expectedTickets.add(new Ticket("Ticket 1", "test d'un ticket"));
        expectedTickets.add(new Ticket("Ticket 2", "Test d'un ticket"));

        Mockito.when(ticketService.getTicketsByColonne(colonneId)).thenReturn(expectedTickets);
        List<Ticket> actualTickets = controller.getTicketsByColonne(colonneId);
        assertEquals(expectedTickets, actualTickets);
    }

    @Test
    public void testDeleteColonne() throws ColonneNotFoundException {
        Colonne colonneToDelete = new Colonne(1L);
        Mockito.when(colonneService.getColonne(1L)).thenReturn(Optional.of(colonneToDelete));
        controller.deleteColonne(1L);
    }
}
