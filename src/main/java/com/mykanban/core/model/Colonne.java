package com.mykanban.core.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Colonne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private Date dateCreation;
    private Date dateModification;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_BOARD")
    private Board board;

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

    @Override
    public String toString() {
        return "Colonne: \nID: " + id + "\nNom: "+nom+"\nDate création: "+dateCreation+"\nDernière modification: "+dateModification+"\nBoard: "+board.getNom();
    }
}
