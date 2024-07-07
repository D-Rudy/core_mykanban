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
    @jakarta.persistence.Column(name = "nom")
    private String name;
    @jakarta.persistence.Column(name = "date_creat")
    private Date creation;
    @jakarta.persistence.Column(name = "date_modif")
    private Date lastUpdate;
    @OneToMany(mappedBy = "board")
    @JsonIgnore
    private List<Colonne> colonnes;

    public Board(String boardName) {
        this.name = boardName;
    }

    public Board() {

    }

    public Board(long l) {
        this.id = l;
    }

    public void setName(String nom) {
        this.name = nom;
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

    public void setCreation(Date date) {
        this.creation = date;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public List<Colonne> getColonnes() {
        return colonnes;
    }

    public void setColonnes(List<Colonne> colonnes) {
        this.colonnes = colonnes;
    }

    @Override
    public String toString() {
        return "Board: \nID: " + id + "\nNom: " + name + "\nDate de création: " + creation + "\nDernière modification: " + lastUpdate;
    }


}
