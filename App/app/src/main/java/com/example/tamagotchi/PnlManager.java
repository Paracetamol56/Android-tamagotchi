package com.example.tamagotchi;

import android.app.Activity;
import android.content.Context;

import com.example.tamagotchi.mvc1.Pnl1_Ctrl;
import com.example.tamagotchi.mvc1.Pnl1_View;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;
import com.example.tamagotchi.mvc2.Pnl2_View;
import com.example.tamagotchi.mvc3.Pnl3_Ctrl;
import com.example.tamagotchi.mvc3.Pnl3_View;

public class PnlManager {

    private static com.example.tamagotchi.PnlManager instance= null;

    private int pnl;

    private Pnl1_View view1;
    private Pnl2_View view2;
    private Pnl3_View view3;

    private Pnl1_Ctrl ctrl1;
    private Pnl2_Ctrl ctrl2;
    private Pnl3_Ctrl ctrl3;

    private Pnl2_Mdl mdl2;

    public Activity refAct;

    private PnlManager(Context context) {
        pnl= -1;
        ctrl1= new Pnl1_Ctrl();
        view1= new Pnl1_View(context);
        mdl2= new Pnl2_Mdl();

        ctrl2= new Pnl2_Ctrl();
        view2= new Pnl2_View(context);

        ctrl3= new Pnl3_Ctrl();
        view3= new Pnl3_View(context);

        view1.setRefCtrl(ctrl1);
        ctrl1.refPnlManager= this;

        view2.refMdl= mdl2;
        ctrl2.refMdl= mdl2;
        view2.setRefCtrl(ctrl2);
        ctrl2.refPnlManager= this;

        view3.setRefCtrl(ctrl3);
        ctrl3.refPnlManager= this;

        refAct= (Activity)context;

        mdl2.addObserver(view2);
    }

    public static com.example.tamagotchi.PnlManager getInstance(Context context) {
        if (instance == null) {
            instance = new com.example.tamagotchi.PnlManager(context);
        }
        return instance;
    }

    public void setPnl(int p) {
        if (p == 1 && pnl != 1) {
            refAct.setContentView(view1);
            pnl= 1;
        }
        if (p == 2 && pnl != 2) {
            refAct.setContentView(view2);
            pnl= 2;
        }
        if (p == 3 && pnl != 3) {
            refAct.setContentView(view3);
            pnl= 3;
        }
    }
}
