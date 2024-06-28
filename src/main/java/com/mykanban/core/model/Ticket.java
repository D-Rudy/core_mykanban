package com.mykanban.core.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String description;
    private int priorite;
    private Date dateCreation;
    private Date dateModification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COLONNE")
    private Colonne colonne;


    public long getId() {
        return id;
    }

    public Colonne getColonne() {
        return colonne;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public String getDescription() {
        return description;
    }

    public int getPriorite() {
        return priorite;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return "Ticket: \nID: " + id + "\nTitre: " + titre + "\nDescription: " + description + "\nPriorite: " + priorite+ "\nColonne: " + colonne.getNom();
    }
}
