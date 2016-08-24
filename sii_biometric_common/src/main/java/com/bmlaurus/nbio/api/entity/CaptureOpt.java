package com.bmlaurus.nbio.api.entity;

import com.nitgen.SDK.BSP.NBioBSPJNI;

/**
 * Created by antonio on 18/08/16.
 */
public class CaptureOpt extends WindowOptions{


    public CaptureOpt(NBioBSPJNI.WINDOW_OPTION winOption) {
        super(winOption);

        this.winOption.WindowStyle = NBioBSPJNI.WINDOW_STYLE.POPUP;
    }

    public CaptureOpt nofingerImage(){
        winOption.WindowStyle |= NBioBSPJNI.WINDOW_STYLE.NO_FPIMG;
        return this;
    }

    /**
     * @param FPWindow Canvas donde se pondra la imagen de la huella. Puede ser nullo
     * */
    public CaptureOpt invisible(java.awt.Canvas FPWindow){
        this.winOption.WindowStyle = NBioBSPJNI.WINDOW_STYLE.INVISIBLE;
        if(FPWindow!=null)
            winOption.FingerWnd = FPWindow;
        return this;
    }

    public CaptureOpt foreColorRGB(int R, int G, int B){
        winOption.FPForeColorR = R;
        winOption.FPForeColorG = G;
        winOption.FPForeColorB = B;
        return this;
    }

    public CaptureOpt backgroundColorRGB(int R, int G, int B){
        winOption.FPBackColorR = R;
        winOption.FPBackColorG = G;
        winOption.FPBackColorB = B;
        return this;
    }

}
