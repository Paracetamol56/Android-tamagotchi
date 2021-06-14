/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc3;

import android.view.KeyEvent;
import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

/**
 * Class
 * @name Pnl3_Ctrl
 * Purpose : Panel 3 | Controller
 */
public class Pnl3_Ctrl implements View.OnClickListener,View.OnKeyListener
{
    // === ATTRIBUTES === //

    // Reference to Manager
    public Pnl3_Mdl refMdl;
<<<<<<< HEAD
    // Reference to View
=======
    public Pnl2_Mdl refMdl2;
>>>>>>> main
    public Pnl3_View refView;
    // Reference to Manager
    public PnlManager refPnlManager;

    // === METHODS === //

    /**
     * @name onClick
     * @param View view
     * @return void
     * @from OnClickListener
     * Purpose : Bind button click with action and panel switching
     */
    @Override
    public void onClick(View view)
    {
        // On button "btnGotoPnl2"
        if (view.getId() == R.id.btnGotoPnl2)
        {
            refPnlManager.setPnl(2);
        }

        // On button "btnReset"
        if (view.getId() == R.id.btnReset)
        {
<<<<<<< HEAD
=======
            //refMdl.reset();
>>>>>>> main
        }
    }

    /**
     * @name onKey
     * @param View view
     * @param int keyCode
     * @param KeyEvent event
     * @return boolean
     * @from OnKeyListener
     * Purpose : Bind key click
     */
    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event)
    {
        // On any key
        if (v.getId() == R.id.inputTamagotchiName)
        {
            refMdl.setTamagotchiNameStr(refView.TamagotchiName.toString());

            refMdl.setPlayerNameStr(refView.PlayerName.toString());
            
        }
        return false;
    }
}
