/**on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc2;

import android.os.Handler;

import java.util.Observable;

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
            happiness = 100;
            Overdose +=10;
        }
        else
        {
            happiness = 100;
            Overdose +=10;
        }
        setChanged();
        notifyObservers();
    }
}
