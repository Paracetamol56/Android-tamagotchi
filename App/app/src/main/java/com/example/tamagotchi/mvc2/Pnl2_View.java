/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc3.Pnl3_Mdl;

import java.util.Observable;
import java.util.Observer;

/**
 * Class
 * @name Pnl2_View
 * Purpose : Panel 2 | View
 */
public class Pnl2_View extends LinearLayout implements Observer
{
    // === ATTRIBUTES === //

    // Reference to Controller
    public Pnl2_Ctrl refCtrl;
    // Reference to Model
    public Pnl2_Mdl refMdl;

    // Buttons
    public Button btnSmoke;
    public Button btnFastFood;
    public Button btnDrugs;
    public Button btnGotoPnl1;
    public Button btnGotoPnl3;

    // Text view
    public TextView txtHeader;
    public TextView txtMessage;
    public TextView txtFaim;
    public TextView txtBonheur;

    // Image view
    public ImageView State;


    public Pnl3_Mdl refMdl3;
    //public Pnl2_Mdl refMdl;
    //public Pnl2_Ctrl refCtrl;


    // === METHODS === //

    /**
     * @name Pnl2_View
     * @param Context context
     * Purpose : Constructor
     */
    public Pnl2_View(Context context) {
        super(context);

        // Inflate layout from xml resources
        LayoutInflater inflater= ((Activity)context).getLayoutInflater();
        inflater.inflate(R.layout.layout_pnl2, this);

        // Find buttons in layout
        btnSmoke = (Button)findViewById(R.id.btnSmoke);
        btnFastFood = (Button)findViewById(R.id.btnFastFood);
        btnDrugs = (Button)findViewById(R.id.btnDrugs);
        btnGotoPnl1 = (Button)findViewById(R.id.btnGotoPnl2);
        btnGotoPnl3 = (Button)findViewById(R.id.btnGotoPnl3);

        // Find TextView in layout
        txtHeader = (TextView)findViewById(R.id.txtHeader);
        txtFaim = (TextView)findViewById(R.id.txtHunger);
        txtBonheur = (TextView)findViewById(R.id.txtHappiness);
        txtMessage = (TextView)findViewById(R.id.txtMessage);

        // Find image view in layout
        State =(ImageView)findViewById(R.id.State);
    }

    /**
     * @name setRefCtrl
     * @param Pnl2_Ctrl c
     * @return void
     * Purpose : Controller reference setter
     */
    public void setRefCtrl(Pnl2_Ctrl c)
    {
        refCtrl= c;
        // Set buttons to OnClickListener
        btnSmoke.setOnClickListener(refCtrl);
        btnFastFood.setOnClickListener(refCtrl);
        btnDrugs.setOnClickListener(refCtrl);
        btnGotoPnl1.setOnClickListener(refCtrl);
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
    public void update(Observable observable, Object arg)
    {
        // Update Textview
        txtFaim.setText(Integer.toString(refMdl.getHunger()));
        txtBonheur.setText(Integer.toString(refMdl.getHappiness()));
        txtMessage.setText(refMdl.getMessage());

        // Update according to mood
        switch (refMdl.getMood())
        {
            case HAPPY:
                txtHeader.setText("Je suinte de bonheur");
                State.setImageResource(R.drawable.heureux);
                break;
            case SAD:
                State.setImageResource(R.drawable.triste);
                break;
            case HUNGRY:
                txtHeader.setText("La foncedalle mon pote");
                State.setImageResource(R.drawable.faim);
                break;
            case DEAD:
                txtHeader.setText("Fallait bien mourir de quelque chose");
                State.setImageResource(R.drawable.mort);
                btnDrugs.setEnabled(false);
                btnFastFood.setEnabled(false);
                btnSmoke.setEnabled(false);
                break;
            case OVERDOSE :
                txtHeader.setText("Je crois que j'ai un peu abusé la bro");
                State.setImageResource(R.drawable.drogue);
                break;
        }
    }
}
