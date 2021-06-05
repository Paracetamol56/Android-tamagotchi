package com.example.tamagotchi.mvc2;

import java.util.Observable;

public class Pnl2_Mdl extends Observable
{
    private int hunger;
    private int happiness;

    private Thread thread;

    public enum state
    {
        HAPPY, SAD, HUNGRY, DEAD
    }
    private state mood;

    long previousTime;
    long currentTime;

    // Constructor
    public Pnl2_Mdl()
    {
        hunger= 0;
        happiness = 100;
        mood = state.HAPPY;

        currentTime = System.currentTimeMillis();
        previousTime = currentTime;

        thread = new Thread() {
            @Override
            public void run() {
                try
                {
                    while (true) {
                        thread.sleep(1000);
                        currentTime = System.currentTimeMillis();
                        
                        if (previousTime - currentTime >= 3000) {
                            if (hunger < 100) {
                                ++hunger;
                            }

                            if (happiness > 0) {
                                --happiness;
                            }

                            if (happiness < 50) {
                                mood = state.SAD;
                            } else {
                                mood = state.HAPPY;
                            }

                            if (hunger > 50) {
                                mood = state.HUNGRY;
                            } else {
                                mood = state.HAPPY;
                            }

                            if (hunger > 100 || happiness < 0) {
                                mood = state.DEAD;
                            }


                            previousTime = currentTime;

                            setChanged();
                            notifyObservers();
                        }
                    }
                }
                catch (InterruptedException e) {}
            }
        };
        thread.start();
    }

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

    public void caresser()
    {
        if (happiness < 100)
        {
            happiness += 2;
        }
    }

    public void jouet()
    {
        if (happiness < 100)
        {
            happiness += 10;
        }
    }

    public void nourrir()
    {
        if (hunger < 100)
        {
            hunger += 10;
        }
    }
}
