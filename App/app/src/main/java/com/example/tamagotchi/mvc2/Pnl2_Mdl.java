package com.example.tamagotchi.mvc2;

import java.util.Observable;

public class Pnl2_Mdl extends Observable
{
    private int hunger;
    private int happyness;

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
        happyness = 100;
        mood = state.HAPPY;

        previousTime = System.currentTimeMillis();
        currentTime = 0;

        thread = new Thread() {
            @Override
            public void run() {
                try
                {
                    while (true) {
                        sleep(1000);
                        currentTime = System.currentTimeMillis();

                        if (previousTime - currentTime > 3000) {
                            if (hunger < 100) {
                                ++hunger;
                            }

                            if (happyness > 0) {
                                --happyness;
                            }

                            if (happyness < 50) {
                                mood = state.SAD;
                            } else {
                                mood = state.HAPPY;
                            }

                            if (hunger > 50) {
                                mood = state.HUNGRY;
                            } else {
                                mood = state.HAPPY;
                            }

                            if (hunger > 100 || happyness < 0) {
                                mood = state.DEAD;
                            }

                            previousTime = currentTime;

                            setChanged();
                            notifyObservers();
                        }
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    public int getHunger()
    {
        return hunger;
    }

    public int getHappyness()
    {
        return happyness;
    }

    public state getMood()
    {
        return mood;
    }

    public void caresser()
    {
        if (happyness < 100)
        {
            happyness += 2;
        }
    }

    public void jouet()
    {
        if (happyness < 100)
        {
            happyness += 10;
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
