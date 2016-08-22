package com.bmlaurus.nbio.api.entity;

import com.nitgen.SDK.BSP.NBioBSPJNI;

/**
 * Created by antonio on 18/08/16.
 */
public abstract class WindowOptions {

    NBioBSPJNI.WINDOW_OPTION    winOption;

    public static final int FINGER_L_LITTLE = 1;
    public static final int FINGER_L_RING = 2;
    public static final int FINGER_L_MIDDLE = 3;
    public static final int FINGER_L_INDEX = 4;
    public static final int FINGER_L_THUMB = 5;

    public static final int FINGER_R_LITTLE = 6;
    public static final int FINGER_R_RING = 7;
    public static final int FINGER_R_MIDDLE = 8;
    public static final int FINGER_R_INDEX = 9;
    public static final int FINGER_R_THUMB = 10;

    protected String cancellMsg;
    protected String captionMsg;

    public WindowOptions(NBioBSPJNI.WINDOW_OPTION winOption) {
        this.winOption = winOption;
    }

    public NBioBSPJNI.WINDOW_OPTION getWinOption() {
        return winOption;
    }

    public WindowOptions setCancellMessage(String msg){
        cancellMsg = msg;
        winOption.CancelMsg = cancellMsg;
        return this;
    }

    public WindowOptions setCaptionMessage(String msg){
        captionMsg = msg;
        winOption.CaptionMsg = captionMsg;
        return this;
    }

    public WindowOptions hideTopMostWindow(){
        winOption.WindowStyle |= NBioBSPJNI.WINDOW_STYLE.NO_TOPMOST;
        return  this;
    }
}
