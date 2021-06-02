package com.example.tamagotchi.mvc2;

import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;

public class Pnl2_Ctrl implements View.OnClickListener {
    public Pnl2_Mdl refMdl;

    public PnlManager refPnlManager;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnPlus) {
            refMdl.incNbVaccins();
        }
        else if (view.getId() == R.id.btnMoins) {
            refMdl.decNbVaccins();
        }
        else if (view.getId() == R.id.btnRaz) {
            refMdl.raz();
        }
        else if (view.getId() == R.id.btnGotoPnl2) {
            refPnlManager.setPnl(1);
        }
        else if (view.getId() == R.id.btnGotoPnl3) {
            refPnlManager.setPnl(3);
        }
    }
}
