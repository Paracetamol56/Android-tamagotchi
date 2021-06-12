package com.example.tamagotchi.mvc3;

import android.widget.EditText;

import java.util.Observable;

public class Pnl3_Mdl extends Observable {
    private String tamagotchiNameStr;
    private String playerNameStr;

    public Pnl3_Mdl() {
        tamagotchiNameStr = "Gros CON";
        playerNameStr = "Le boss";
    }

    public void setTamagotchiNameStr(String tamagotchiNameStr) {
        this.tamagotchiNameStr = tamagotchiNameStr;
        setChanged();
        notifyObservers();
    }

    public void setPlayerNameStr(String playerNameStr) {
        this.playerNameStr = playerNameStr;
        setChanged();
        notifyObservers();
    }

    public String getTamagotchiNameStr() {
        return tamagotchiNameStr;
    }

    public String getPlayerNameStr() {
        return playerNameStr;
    }

}