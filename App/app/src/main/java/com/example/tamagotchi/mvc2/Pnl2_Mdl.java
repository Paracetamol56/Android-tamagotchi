package com.example.tamagotchi.mvc2;

import android.os.Handler;
import android.util.Log;

import java.util.Observable;

public class Pnl2_Mdl extends Observable
{
    private int hunger;
    private int happiness;

    private Thread thread;
    private Handler m_Handler = new Handler();

    public enum state
    {
        HAPPY, SAD, HUNGRY, DEAD
    }
    private state mood;

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

    private long previousTime;

    // Constructor
    public Pnl2_Mdl()
    {
        // Initialize every variables
        hunger = 0;
        happiness = 100;
        mood = state.HAPPY;

        // Apply changes and notify the view
        setChanged();
        notifyObservers();

        m_Handler.postDelayed(mToastRunnable, 500);
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
            if (mood != state.DEAD)
            {
                if (hunger < 100) {
                    ++hunger;
                }

                if (happiness > 0) {
                    --happiness;
                }
            }

            if (happiness < 50) {
                mood = state.SAD;
            }
            else {
                mood = state.HAPPY;
            }

            if (hunger > 50) {
                mood = state.HUNGRY;
            }

            if (hunger == 100 || happiness == 0) {
                mood = state.DEAD;
            }

            setChanged();
            notifyObservers();

            Log.i("YES", "MAN");

            m_Handler.postDelayed(this, 500);
        }
    };

    public int getHunger()
    {
        return hunger;
    }

    public int getHappiness()
    {
        return happiness;
    }

    public state getMood()
    {
        return mood;
    }

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
        setChanged();
        notifyObservers();
    }

    public void fastFood()
    {
        if (hunger > 9)
        {
            hunger -= 10;
            setChanged();
            notifyObservers();
        }
        else
        {
            hunger = 0;
        }
        setChanged();
        notifyObservers();
    }

    public void drugs()
    {
        if (happiness < 100)
        {
            happiness += 10;
        }
        else
        {
            happiness = 100;
        }
        setChanged();
        notifyObservers();
    }
}
