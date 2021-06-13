/*
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

public class Pnl2_Ctrl implements View.OnClickListener {
    public Pnl2_Mdl refMdl;

    public PnlManager refPnlManager;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnSmoke) {
            refMdl.smoke();
        }
        else if (view.getId() == R.id.btnFastFood) {
            refMdl.fastFood();
        }
        else if (view.getId() == R.id.btnDrugs) {
            refMdl.drugs();
        }
        else if (view.getId() == R.id.btnGotoPnl1) {
            refPnlManager.setPnl(1);
        }
        else if (view.getId() == R.id.btnGotoPnl3) {
            refPnlManager.setPnl(3);
        }
    }
}
