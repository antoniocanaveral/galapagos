package com.bmlaurus.nbio.api.entity;

import com.nitgen.SDK.BSP.NBioBSPJNI;

/**
 * Created by antonio on 18/08/16.
 */
public class Enrollment extends WindowOptions{

    public Enrollment(NBioBSPJNI.WINDOW_OPTION winOption){
        super(winOption);

        //Set defaults
        this.winOption.DisableFingerForEnroll0 = 1;
        this.winOption.DisableFingerForEnroll1 = 1;
        this.winOption.DisableFingerForEnroll2 = 1;
        this.winOption.DisableFingerForEnroll3 = 1;
        this.winOption.DisableFingerForEnroll4 = 1;
        this.winOption.DisableFingerForEnroll5 = 1;
        this.winOption.DisableFingerForEnroll6 = 1;
        this.winOption.DisableFingerForEnroll7 = 1;
        this.winOption.DisableFingerForEnroll8 = 1;
        this.winOption.DisableFingerForEnroll9 = 1;

        //Para enrolar debe ser obligatoriamente popup.
        this.winOption.WindowStyle = NBioBSPJNI.WINDOW_STYLE.POPUP;

    }

    public Enrollment hideWelcomeWindow(){
        winOption.WindowStyle |= NBioBSPJNI.WINDOW_STYLE.NO_WELCOME;
        return this;
    }

    public Enrollment fingersDisable(int ... fingers){

        for(int finger:fingers){
            switch (finger){
                case FINGER_L_THUMB:
                    winOption.DisableFingerForEnroll0 = 0;
                    break;
                case FINGER_L_INDEX:
                    winOption.DisableFingerForEnroll1 = 0;
                    break;
                case FINGER_L_MIDDLE:
                    winOption.DisableFingerForEnroll2 = 0;
                    break;
                case FINGER_L_RING:
                    winOption.DisableFingerForEnroll3 = 0;
                    break;
                case FINGER_L_LITTLE:
                    winOption.DisableFingerForEnroll4 = 0;
                    break;
                case FINGER_R_THUMB:
                    winOption.DisableFingerForEnroll5 = 0;
                    break;
                case FINGER_R_INDEX:
                    winOption.DisableFingerForEnroll6 = 0;
                    break;
                case FINGER_R_MIDDLE:
                    winOption.DisableFingerForEnroll7 = 0;
                    break;
                case FINGER_R_RING:
                    winOption.DisableFingerForEnroll8 = 0;
                    break;
                case FINGER_R_LITTLE:
                    winOption.DisableFingerForEnroll9 = 0;
                    break;
            }
        }
        return this;
    }
}
