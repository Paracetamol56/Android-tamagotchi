/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Class
 * @name Pnl1_View
 * Purpose : Panel 1 | View
 */
public class Pnl1_View extends LinearLayout implements Observer
{
    // === ATTRIBUTES === //

    // Reference to Controller
    public Pnl1_Ctrl refCtrl;
    // Reference to Model
    public Pnl1_Mdl refMdl;

    // Buttons
    public Button btnGotoPnl2;
    public Button btnGotoPnl3;

    // Image view
    public ImageView Image;

    // === METHODS === //

    /**
     * @name Pnl1_View
     * @param Context context
     * Purpose : Constructor
     */
    public Pnl1_View(Context context)
    {
        super(context);

        // Inflate layout from xml resources
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl1, this);

        // Find buttons in layout
        btnGotoPnl2 = (Button)findViewById(R.id.btnGotoPnl2);
        btnGotoPnl3 = (Button)findViewById(R.id.btnGotoPnl3);

        // Find image view in layout
        Image=(ImageView)findViewById(R.id.MainImage);

        // Generate random number
        final int random = new Random().nextInt(4);

        // Choose an image to display on the front page
        switch (random)
        {
            case 0 :
                Image.setImageResource(R.drawable.heureux);
                break;
            case 1 :
                Image.setImageResource(R.drawable.triste);
                break;
            case 2 :
                Image.setImageResource(R.drawable.faim);
                break;
            case 3 :
                Image.setImageResource(R.drawable.drogue);
                break;
        }
    }

    /**
     * @name setRefCtrl
     * @param Pnl1_Ctrl c
     * @return void
     * Purpose : Controller reference setter
     */
    public void setRefCtrl(Pnl1_Ctrl c)
    {
        refCtrl = c;
        // Set buttons to OnClickListener
        btnGotoPnl2.setOnClickListener(refCtrl);
        btnGotoPnl3.setOnClickListener(refCtrl);
    }

    /**
     * @name update
     * @param Observable o
     * @param Object arg
     * @return void
     * @from Observer
     * Purpose : Update the view
     */
    @Override
    public void update(Observable o, Object arg)
    {
    }
}
