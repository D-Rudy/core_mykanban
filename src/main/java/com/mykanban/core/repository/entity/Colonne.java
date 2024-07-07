package com.mykanban.core.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "colonne")
public class Colonne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @jakarta.persistence.Column(name = "nom")
    private String name;
    @jakarta.persistence.Column(name = "date_creat")
    private Date creation;
    @jakarta.persistence.Column(name = "date_modif")
    private Date lastUpdate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_board")
    private Board board;
    @OneToMany(mappedBy = "colonne")
    @JsonIgnore
    private List<Ticket> tickets;

    public Colonne(String name) {
        this.name = name;
    }

    public Colonne() {
    }

    public Colonne(long id){
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreation() {
        return creation;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Board getBoard() {
        return board;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public void setCreation(Date dateCreation) {
        this.creation = dateCreation;
    }

    public void setLastUpdate(Date dateModification) {
        this.lastUpdate = dateModification;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Colonne: \nID: " + id + "\nNom: " + name + "\nDate création: " + creation + "\nDernière modification: " + lastUpdate + "\nBoard: " + board.getName();
    }
}
