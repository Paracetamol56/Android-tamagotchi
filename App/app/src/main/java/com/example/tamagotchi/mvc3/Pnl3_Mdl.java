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
    }

    public void setPlayerNameStr(String playerNameStr) {
        this.playerNameStr = playerNameStr;
    }

    public String getTamagotchiNameStr() {
        return tamagotchiNameStr;
    }

    public String getPlayerNameStr() {
        return playerNameStr;
    }
}