/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Class
 * @name MainActivity
 * Purpose : Main Activity handler
 */
public class MainActivity extends AppCompatActivity
{
    // === ATTRIBUTES === //

    MediaPlayer player;

    // === METHODS === //

    /**
     * @name onCreate
     * @param Bundle savedInstanceState
     * @return void
     * @from AppCompatActivity
     * Purpose : Initializer
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Start with panel 1
        PnlManager manager= PnlManager.getInstance(this);
        manager.setPnl(1);

        player = MediaPlayer.create(this, R.raw.backgroundmusic);
        player.setLooping(true);
        player.start();
    }
}