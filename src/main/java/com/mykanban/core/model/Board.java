package com.mykanban.core.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private Date dateCreation;
    private Date dateModification;


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

    public Date getDateModification() {
        return dateModification;
    }

    @Override
    public String toString() {
        return "Board: \nID: " + id + "\nNom: " + nom + "\nDate de création: " + dateCreation + "\nDernière modification: " + dateModification;
    }
}
