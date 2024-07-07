package com.mykanban.core.repository.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @jakarta.persistence.Column(nullable = false, name = "titre")
    private String title;
    @jakarta.persistence.Column(nullable = false, name = "description")
    private String description;
    @jakarta.persistence.Column(nullable = false, name = "priorite", columnDefinition = "int (1) default '1'")
    private int priority;
    @jakarta.persistence.Column(name = "date_creat")
    private Date creation;
    @jakarta.persistence.Column(name = "date_modif")
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "id_colonne")
    private Colonne colonne;

    public Ticket(String title, String description) {
        this.title = title;
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

    public Date getCreation() {
        return creation;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Ticket: \nID: " + id + "\nTitre: " + title + "\nDescription: " + description + "\nPriorite: " + priority + "\nColonne: " + colonne.getName();
    }
}
