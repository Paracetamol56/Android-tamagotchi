/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc2;

import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;

/**
 * Class
 * @name Pnl2_Ctrl
 * Purpose : Panel 2 | Controller
 */
public class Pnl2_Ctrl implements View.OnClickListener
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
     * Purpose : Bind button click with action and panel switching
     */
    @Override
    public void onClick(View view) {
        // On button "btnSmoke"
        if (view.getId() == R.id.btnSmoke)
        {
            refMdl.smoke();
        }

        // On button "btnFastFood"
        else if (view.getId() == R.id.btnFastFood)
        {
            refMdl.fastFood();

        }

        // On button "btnDrugs"
        else if (view.getId() == R.id.btnDrugs)
        {
            refMdl.drugs();
        }

        // On button "btnGotoPnl2"
        else if (view.getId() == R.id.btnGotoPnl2)
        {
            refPnlManager.setPnl(1);
        }

        // On button "btnGotoPnl3"
        else if (view.getId() == R.id.btnGotoPnl3)
        {
            refPnlManager.setPnl(3);
        }
    }
}
