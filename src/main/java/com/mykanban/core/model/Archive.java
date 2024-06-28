package com.mykanban.core.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date dateCreation;
    private Date dateModification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_TICKET")
    private Ticket ticket;

    public long getId() {
        return id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public Ticket getTicket() {
        return ticket;
    }

    @Override
    public String toString() {
        return "Archive{" +
                "\nID" + id +
                "\nDate création=" + dateCreation +
                "\nDerniere modification=" + dateModification +
                "\nticket=" + ticket.getTitre() +
                '}';
    }
}
