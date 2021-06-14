/**on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc2;

import android.os.Handler;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc3.Pnl3_Mdl;

import java.util.Observable;
import java.util.Random;

/**
 * Class
 * @name Pnl1_Mdl
 * Purpose : Panel 2 | Model
 */
public class Pnl2_Mdl extends Observable
{
    // === ATTRIBUTES === //


    // Tamagotchi variables
    private int hunger;
    private int happiness;
    private int Overdose;

    private String message;
    private String Name;

    // Timer thread
    private Thread thread;
    // Timer thread handler
    private Handler m_Handler = new Handler();

    // Enum of states
    public enum state
    {
        HAPPY, SAD, HUNGRY, DEAD, OVERDOSE
    }

    // Current mood
    private state mood;

    // Enum of drugs
    public enum drug
    {
        CANNABIS,
        COCAINE,
        OPIUM,
        MORPHINE,
        LSD,
        GHB,
        METHAMPHETAMINE,
        PSYCHOANALEPTIQUES,
        THYMOANALEPTIQUES
    }

    // CANNABIS : delta9-tétrahydrocannabinol
    // COCAINE : chlorhydrate de cocaïne
    // OPIUM
    // MORPHINE
    // LSD : diéthyllysergamide
    // GHB : acide GammaHydroxyButyrique
    // METHAMPHETAMINE : méthamphétamine
    // PSYCHOANALEPTIQUES psychoanaleptiques
    // THYMOANALEPTIQUES : thymoanaleptiques

    // === METHODS === //

    /**
     * @name Pnl2_Mdl
     * Purpose : Constructor
     */
    public Pnl2_Mdl()
    {
        // Initialize every variables
        hunger = 0;
        happiness = 100;
        Overdose = 0;
        mood = state.HAPPY;
        message = "Je suis content";

        // Apply changes and notify the view
        setChanged();
        notifyObservers();

        // Initiate the handler
        m_Handler.postDelayed(mToastRunnable, 2000);
    }

    // Create runnable
    private Runnable mToastRunnable = new Runnable() {
        /**
         * @name run
         * @return void
         * @from Runnable
         * Purpose : Actions to run
         */
        @Override
        public void run() {
            // Increment values
            if (mood != state.DEAD)
            {
                if (hunger < 100) {
                    hunger+=1;
                }

                if (happiness > 0) {
                    happiness-=1;
                }

                if (Overdose >0){
                    --Overdose;
                }
            }

            // Mood = SAD ?
            if (happiness < 50) {
                mood = state.SAD;
            }
            // Mood = HAPPY ?
            else {
                mood = state.HAPPY;
            }

            // Mood = HUNGRY ?
            if (hunger > 50) {
                mood = state.HUNGRY;
            }

            // Overdose ?
            if (Overdose >= 80){
                mood= state.OVERDOSE;
                message = "C'est moi ou je vois un arc en ciel ?";
            }

            // Mood = DEAD ?
            if (hunger == 100 || happiness == 0 || Overdose >=100) {
                mood = state.DEAD;
            }

            // Apply changes and notify the view
            setChanged();
            notifyObservers();

            // Set handler delay for next run
            m_Handler.postDelayed(this, 2000);
        }
    };

    /**
     * @name getHunger
     * @return int hunger
     * Purpose : hunger getter
     */
    public int getHunger()
    {
        return hunger;
    }

    /**
     * @name getHappiness
     * @return int happiness
     * Purpose : happiness getter
     */
    public int getHappiness()
    {
        return happiness;
    }

    /**
     * @name getMood
     * @return state mood
     * Purpose : mood getter
     */
    public state getMood()
    {
        return mood;
    }

    /**
     * @name getMessage
     * @return String message
     * Purpose : message getter
     */
    public String getMessage() {
        return message;
    }

    /**
     * @name smoke
     * @return void
     * Purpose : modify values when smoke
     */
    public void smoke()
    {
        if (happiness < 91)
        {
            happiness += 10;
        }
        else
        {
            happiness = 100;
        }

        message = "Chacun son cancer";

        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

    /**
     * @name fastFood
     * @return void
     * Purpose : modify values when fastFood
     */
    public void fastFood()
    {
        if (hunger > 9)
        {
            hunger -= 10;
        }
        else
        {
            hunger = 0;
        }

        message = "Miam Miam";

        // Apply changes and notify the view
        setChanged();
        notifyObservers();
    }

    /**
     * @name drugs
     * @return void
     * Purpose : modify values when drugs
     */
    public void drugs()
    {
        if (happiness < 91)
        {
            happiness += 10;
            Overdose +=10;
        }
        else
        {
            happiness = 100;
            Overdose +=10;
        }

        // Generate random number
        final int random = new Random().nextInt(9);

        // Choose a drug
        switch (random)
        {
            // CANNABIS : delta9-tétrahydrocannabinol
            case 0 :
                message = "Un peu de delta9-tétrahydrocannabinol";
                break;
            // COCAINE : chlorhydrate de cocaïne
            case 1 :
                message = "chlorhydrate de cocaïne";
                break;
            // OPIUM
            case 2 :
                message = "opium";
                break;
            // MORPHINE
            case 3 :
                message = "morphine";
                break;
            // LSD : diéthyllysergamide
            case 4 :
                message = "diéthyllysergamide";
                break;
            // GHB : acide GammaHydroxyButyrique
            case 5 :
                message = "acide GammaHydroxyButyrique";
                break;
            // METHAMPHETAMINE : méthamphétamine
            case 6 :
                message = "méthamphétamine";
                break;
            // PSYCHOANALEPTIQUES psychoanaleptiques
            case 7 :
                message = "psychoanaleptiques";
                break;
            // THYMOANALEPTIQUES : thymoanaleptiques
            case 8 :
                message = "thymoanaleptiques";
                break;
        }

        if (Overdose > 65)
        {
            message = "Fais gaffe, l'overdose est proche";
        }

        setChanged();
        notifyObservers();
    }


}
