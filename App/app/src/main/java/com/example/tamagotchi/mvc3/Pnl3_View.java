/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tamagotchi.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Observable;
import java.util.Observer;

/**
 * Class
 * @name Pnl3_View
 * Purpose : Panel 3 | View
 */
public class Pnl3_View extends LinearLayout implements Observer
{
    // === ATTRIBUTES === //

    // Reference to Controller
    public Pnl3_Ctrl refCtrl;
    // Reference to Model
    public Pnl3_Mdl refMdl;

    // Buttons
    public Button btnGotoPnl2;
    public Button btnReset;

    // Text input
    public TextInputEditText TamagotchiName;
    public TextInputEditText PlayerName;

    /**
     * @name Pnl3_View
     * @param Context context
     * Purpose : Constructor
     */
    @SuppressLint("WrongViewCast")
    public Pnl3_View(Context context)
    {
        super(context);

        // Inflate layout from xml resources
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl3, this);

        // Find buttons in layout
        btnGotoPnl2 = (Button)findViewById(R.id.btnGotoPnl2);
        btnReset = (Button)findViewById(R.id.btnReset);

        // Find TextInputEditText in layout
        TamagotchiName = (TextInputEditText)findViewById(R.id.inputTamagotchiName);
        PlayerName = (TextInputEditText)findViewById(R.id.inputPlayerName);

        btnReset.setOnClickListener(new View.OnClickListener()
        {
            /**
             * @name onClick
             * @param View view
             * @return void
             * @from OnClickListener
             * Purpose : Bind text edit click with action
             */
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                TamagotchiName.getText().clear();

                // Clear the second EditText
<<<<<<< HEAD
                PlayerName.setText("");
=======
                PlayerName.getText().clear();
                refMdl.reset();
>>>>>>> main
            }
        });
    }

    /**
     * @name setRefCtrl
     * @param Pnl3_Ctrl c
     * @return void
     * Purpose : Controller reference setter
     */
    public void setRefCtrl(Pnl3_Ctrl c)
    {
        refCtrl= c;
        btnGotoPnl2.setOnClickListener(refCtrl);
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
        TamagotchiName.setText(refMdl.getTamagotchiNameStr());
        PlayerName.setText(refMdl.getPlayerNameStr());
    }


}
