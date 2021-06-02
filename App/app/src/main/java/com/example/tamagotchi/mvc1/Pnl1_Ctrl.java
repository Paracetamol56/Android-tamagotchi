package com.example.tamagotchi.mvc1;

import android.view.View;

import com.example.tamagotchi.PnlManager;
import com.example.tamagotchi.R;


public class Pnl1_Ctrl implements View.OnClickListener {
    public PnlManager refPnlManager;

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnGotoPnl2) {
            refPnlManager.setPnl(2);
        }
    }

}
