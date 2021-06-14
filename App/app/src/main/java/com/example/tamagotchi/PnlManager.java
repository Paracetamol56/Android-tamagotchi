/**
 * Created on Sun Jun 13 2021
 *
 * Copyright (c) 2021 - Mathéo G & Sahel H - All Right Reserved
 *
 * Licensed under the Apache License, Version 2.0
 * Available on GitHub at https://github.com/Paracetamol56/Android-tamagotchi
 */

package com.example.tamagotchi;

import android.app.Activity;
import android.content.Context;

import com.example.tamagotchi.mvc1.Pnl1_Ctrl;
import com.example.tamagotchi.mvc1.Pnl1_Mdl;
import com.example.tamagotchi.mvc1.Pnl1_View;
import com.example.tamagotchi.mvc2.Pnl2_Ctrl;
import com.example.tamagotchi.mvc2.Pnl2_Mdl;
import com.example.tamagotchi.mvc2.Pnl2_View;
import com.example.tamagotchi.mvc3.Pnl3_Ctrl;
import com.example.tamagotchi.mvc3.Pnl3_Mdl;
import com.example.tamagotchi.mvc3.Pnl3_View;

/**
 * Class
 * @name PnlManager
 * Purpose : Store the 3 panels MVC and handle transition between them
 */
public class PnlManager
{
    // === ATTRIBUTES === //

    // Instance of itsefl for singleton
    private static com.example.tamagotchi.PnlManager instance = null;

    // Pannel index
    private int pnl;

    // Pannel 1 MVC
    private Pnl1_View view1;
    private Pnl1_Ctrl ctrl1;
    private Pnl1_Mdl mdl1;

    // Pannel 2 MVC
    private Pnl2_View view2;
    private Pnl2_Ctrl ctrl2;
    private Pnl2_Mdl mdl2;

    // Pannel 3 MVC
    private Pnl3_View view3;
    private Pnl3_Ctrl ctrl3;
    private Pnl3_Mdl mdl3;

    // Reference to activity
    public Activity refAct;

    // === METHODS === //

    /**
     * @name PnlManager
     * @param Context context
     * Purpose : Constructor
     */
    private PnlManager(Context context)
    {
        // Initialize pnl attribute to -1 (default value)
        pnl = -1;

        // Panel 1 Initiate with new objects
        mdl1 = new Pnl1_Mdl();
        ctrl1 = new Pnl1_Ctrl();
        view1 = new Pnl1_View(context);

        // Panel 2 Initiate with new objects
        mdl2 = new Pnl2_Mdl();
        ctrl2 = new Pnl2_Ctrl();
        view2 = new Pnl2_View(context);

        // Panel 3 Initiate with new objects
        mdl3 = new Pnl3_Mdl();
        ctrl3 = new Pnl3_Ctrl();
        view3 = new Pnl3_View(context);

        // Panel 1 Setup references
        view1.refMdl = mdl1;
        view1.refCtrl = ctrl1;
        view1.setRefCtrl(ctrl1);
        ctrl1.refPnlManager = this;

        // Panel 2 Setup references
        view2.refMdl = mdl2;
        ctrl2.refMdl = mdl2;
        view2.setRefCtrl(ctrl2);
        ctrl2.refPnlManager = this;

        // Panel 3 Setup references
        view3.refMdl = mdl3;
        ctrl3.refMdl = mdl3;
        view3.setRefCtrl(ctrl3);
        ctrl3.refPnlManager = this;

        // Setup the reference to activity
        refAct = (Activity)context;

        // Setup observer/observables relation
        mdl1.addObserver(view1);
        mdl2.addObserver(view2);
        mdl3.addObserver(view3);
    }

    /**
     * @name getInstance
     * @param Context context
     * @return com.example.tamagotchi.PnlManager instance
     * Purpose : Self instance getter
     */
    public static com.example.tamagotchi.PnlManager getInstance(Context context)
    {
        if (instance == null)
        {
            instance = new com.example.tamagotchi.PnlManager(context);
        }
        return instance;
    }

    /**
     * @name setPnl
     * @param int p
     * @return void
     * Purpose : Set the active panel to p
     */
    public void setPnl(int p)
    {
        // Switch to panel 1
        if (p == 1 && pnl != 1)
        {
            refAct.setContentView(view1);
            pnl= 1;
        }
        // Switch to panel 2
        if (p == 2 && pnl != 2)
        {
            refAct.setContentView(view2);
            pnl= 2;
        }
        // Switch to panel 3
        if (p == 3 && pnl != 3)
        {
            refAct.setContentView(view3);
            pnl= 3;
        }
    }
}
