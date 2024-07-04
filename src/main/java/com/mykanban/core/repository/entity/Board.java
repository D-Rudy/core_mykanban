package com.mykanban.core.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "date_creat")
    private Date dateCreation;
    @Column(name = "date_modif")
    private Date dateModification;
    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<Colonne> colonnes;

    public Board(String boardName) {
        this.nom = boardName;
    }

    public Board() {

    }

    public Board(long l) {
        this.id = l;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public void setDateCreation(Date date) {
        this.dateCreation = date;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public List<Colonne> getColonnes() {
        return colonnes;
    }

    public void setColonnes(List<Colonne> colonnes) {
        this.colonnes = colonnes;
    }

    @Override
    public String toString() {
        return "Board: \nID: " + id + "\nNom: " + nom + "\nDate de création: " + dateCreation + "\nDernière modification: " + dateModification;
    }


}
