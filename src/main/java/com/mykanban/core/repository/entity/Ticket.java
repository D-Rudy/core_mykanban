package com.mykanban.core.repository.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, name = "titre")
    private String titre;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "priorite", columnDefinition = "int (1) default '1'")
    private int priorite;
    @Column(name = "date_creat")
    private Date dateCreation;
    @Column(name = "date_modif")
    private Date dateModification;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_colonne")
    private Colonne colonne;

    public Ticket(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Ticket() {

    }

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
        return "Ticket: \nID: " + id + "\nTitre: " + titre + "\nDescription: " + description + "\nPriorite: " + priorite + "\nColonne: " + colonne.getNom();
    }
}
