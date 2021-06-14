/*
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi.mvc3;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class Pnl3_Ctrl implements View.OnClickListener,View.OnKeyListener
{
    public Pnl3_Mdl refMdl;
    public Pnl2_Mdl refMdl2;
    public Pnl3_View refView;
    public PnlManager refPnlManager;

    @Override
    public void onClick(View view)
    {
        if (view.getId() == R.id.btnGotoPnl2)
        {
            refPnlManager.setPnl(2);
        }

        if (view.getId() == R.id.btnReset)
        {
            //refMdl.reset();
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event)
    {
        if (v.getId() == R.id.inputTamagotchiName)
        {
            refMdl.setTamagotchiNameStr(refView.TamagotchiName.toString());

            refMdl.setPlayerNameStr(refView.PlayerName.toString());
            
        }
        return false;
    }
}
