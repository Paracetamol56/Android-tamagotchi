/*
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

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

    public void setTamagotchiNameStr(String tamagotchiNameStr)
    {
        this.tamagotchiNameStr = tamagotchiNameStr;
        setChanged();
        notifyObservers();
    }

    public void setPlayerNameStr(String playerNameStr)
    {
        this.playerNameStr = playerNameStr;
        setChanged();
        notifyObservers();
    }

    public String getTamagotchiNameStr()
    {
        return tamagotchiNameStr;
    }

    public String getPlayerNameStr()
    {
        return playerNameStr;
    }

    public void reset()
    {
        this.tamagotchiNameStr = "Gros CON";
        this.playerNameStr = "Le boss";

        setChanged();
        notifyObservers();
    }

}