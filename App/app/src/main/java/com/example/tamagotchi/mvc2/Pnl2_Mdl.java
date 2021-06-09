package com.example.tamagotchi.mvc2;

import android.os.Handler;
import android.util.Log;

import java.util.Observable;

public class Pnl2_Mdl extends Observable
{
    private int hunger;
    private int happiness;
    private int Overdose;

    private Thread thread;
    private Handler m_Handler = new Handler();

    public enum state
    {
        HAPPY, SAD, HUNGRY, DEAD, OVERDOSE
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
        Overdose = 0;
        mood = state.HAPPY;

        // Apply changes and notify the view
        setChanged();
        notifyObservers();

        m_Handler.postDelayed(mToastRunnable, 2000);
    }

    private Runnable mToastRunnable = new Runnable() {
        @Override
        public void run() {
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

            if (happiness < 50) {
                mood = state.SAD;
            }
            else {
                mood = state.HAPPY;
            }

            if (hunger > 50) {
                mood = state.HUNGRY;
            }

            if (Overdose >= 80){
                mood= state.OVERDOSE;
            }

            if (hunger == 100 || happiness == 0 || Overdose >=100) {
                mood = state.DEAD;
            }





            setChanged();
            notifyObservers();

            Log.i("YES", "MAN");

            m_Handler.postDelayed(this, 2000);
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
