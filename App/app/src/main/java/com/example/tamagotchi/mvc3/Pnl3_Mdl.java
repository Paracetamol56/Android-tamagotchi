/**
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

/**
 * Class
 * @name Pnl3_Mdl
 * Purpose : Panel 3 | Model
 */
public class Pnl3_Mdl extends Observable
{
    // === ATTRIBUTES === //

    // Tamagotchi strings
    private String tamagotchiNameStr;
    private String playerNameStr;

    // === METHODS === //

    /**
     * @name Pnl3_Mdl
     * Purpose : Constructor
     */
    public Pnl3_Mdl() {
        // Initialize every variables
        tamagotchiNameStr = "Gros CON";
        playerNameStr = "Le boss";

        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

    /**
     * @name setTamagotchiNameStr
     * @param String tamagotchiNameStr
     * @return void
     * Purpose : tamagotchiName setter
     */
    public void setTamagotchiNameStr(String tamagotchiNameStr)
    {
        this.tamagotchiNameStr = tamagotchiNameStr;

        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

    /**
     * @name setPlayerNameStr
     * @param String playerNameStr
     * @return void
     * Purpose : PlayerName setter
     */
    public void setPlayerNameStr(String playerNameStr)
    {
        this.playerNameStr = playerNameStr;

        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

    /**
     * @name getTamagotchiNameStr
     * @return String tamagotchiNameStr
     * Purpose : TamagotchiName getter
     */
    public String getTamagotchiNameStr()
    {
        return tamagotchiNameStr;
    }

    /**
     * @name getPlayerNameStr
     * @return String playerNameStr
     * Purpose : playerName getter
     */
    public String getPlayerNameStr()
    {
        return playerNameStr;
    }

    /**
     * @name reset
     * @return void
     * Purpose : reset variables
     */
    public void reset()
    {
        // Reinitialize every variables
        this.tamagotchiNameStr = "Bud";
        this.playerNameStr = "Gorgious";
        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

}