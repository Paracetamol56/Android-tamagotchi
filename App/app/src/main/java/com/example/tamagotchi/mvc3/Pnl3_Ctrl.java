package com.example.tamagotchi.mvc3;

import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;

public class Pnl3_Ctrl implements View.OnClickListener {
    public Pnl3_Mdl refMdl;

    public PnlManager refPnlManager;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.inputTamagotchiName) {
        }
    }
}
