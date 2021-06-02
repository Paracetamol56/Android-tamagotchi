package com.example.tamagotchi.mvc3;

import java.util.Observable;

public class Pnl3_Mdl extends Observable {
    private int nbVaccins;
    private int nbVaccinsMax;
    private int nbVaccinsMin;

    // Constructor
    public Pnl3_Mdl() {
        nbVaccins= 0;
        nbVaccinsMax = 10;
        nbVaccinsMin = 0;
    }

    public void incNbVaccins() {
        if (nbVaccins < nbVaccinsMax) {
            nbVaccins++;
        }
        setChanged();
        notifyObservers();
    }

    public void decNbVaccins() {
        if (nbVaccins > nbVaccinsMin) {
            nbVaccins--;
        }
        setChanged();
        notifyObservers();
    }

    public void raz() {
        nbVaccins = nbVaccinsMin;
        setChanged();
        notifyObservers();
    }

    public int getNbVaccins() {
        return nbVaccins;
    }

    public boolean nbVaccinsMax() {
        return nbVaccins < nbVaccinsMax;
    }

    public boolean nbVaccinsMin() {
        return nbVaccins > nbVaccinsMin;
    }
}
