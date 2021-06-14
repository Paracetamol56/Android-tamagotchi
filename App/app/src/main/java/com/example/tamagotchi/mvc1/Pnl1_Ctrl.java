/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc1;

import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

/**
 * Class
 * @name Pnl1_Ctrl
 * Purpose : Panel 1 | Controller
 */
public class Pnl1_Ctrl implements View.OnClickListener
{
    // === ATTRIBUTES === //

    // Reference to Manager
    public Pnl2_Mdl refMdl;
    // Reference to Manager
    public PnlManager refPnlManager;

    // === METHODS === //

    /**
     * @name onClick
     * @param View view
     * @return void
     * @from OnClickListener
     * Purpose : Bind button click with panel switching
     */
    @Override
    public void onClick(View view)
    {
        // On button "btnGotoPnl2"
        if (view.getId() == R.id.btnGotoPnl2)
        {
            refPnlManager.setPnl(2);
        }

        // On button "btnGotoPnl3"
        if (view.getId() == R.id.btnGotoPnl3)
        {
            refPnlManager.setPnl(3);
        }
    }
}
