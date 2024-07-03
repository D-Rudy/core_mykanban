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
    @Column(name = "nom")
    private String nom;
    @Column(name = "date_creat")
    private Date dateCreation;
    @Column(name = "date_modif")
    private Date dateModification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_board")
    private Board board;
    @OneToMany(mappedBy = "colonne")
    @JsonIgnore
    private List<Ticket> tickets;

    public Colonne(String nom) {
        this.nom = nom;
    }

    public Colonne() {
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        return "Colonne: \nID: " + id + "\nNom: " + nom + "\nDate création: " + dateCreation + "\nDernière modification: " + dateModification + "\nBoard: " + board.getNom();
    }
}
