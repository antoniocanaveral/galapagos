package com.bmlaurus.signature;

import com.topaz.sigplus.SigPlus;
import netscape.javascript.JSObject;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.beans.Beans;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
/**
 * Created by antonio on 15/08/16.
 */
public class SigPlusImgDemo extends Applet implements Runnable{

    private SigPlus     sigObj = null;
    private Thread      eventThread;

    //PARAMETROS
    private String      model = "SignatureGem1X5";
    private String      comPort = "HID1";
    private boolean     generateImg = false;

    public void init( )
    {
        if(this.getParameter("model")!=null)
            model=this.getParameter("model");
        if(this.getParameter("comPort")!=null)
            comPort=this.getParameter("comPort");
        if(this.getParameter("generateImg")!=null)
            generateImg=Boolean.parseBoolean(this.getParameter("generateImg"));

        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        setLayout(gbl);
        Panel controlPanel = new Panel();
        setConstraints(controlPanel, gbl, gc, 0, 0,
                GridBagConstraints.REMAINDER, 1, 0, 0,
                GridBagConstraints.CENTER,
                GridBagConstraints.NONE,0, 0, 0, 0);
        add(controlPanel, gc);


        Button clearButton = new Button("Limpiar");
        controlPanel.add(clearButton);

        Button saveJpgButton = new Button("Guardar");
        controlPanel.add(saveJpgButton);

        try
        {
            ClassLoader cl = (com.topaz.sigplus.SigPlus.class).getClassLoader();
            sigObj = (SigPlus)Beans.instantiate( cl, "com.topaz.sigplus.SigPlus" );

            setConstraints(sigObj, gbl, gc, 0, 1,
                    GridBagConstraints.REMAINDER, 1, 1, 1,
                    GridBagConstraints.CENTER,
                    GridBagConstraints.BOTH, 5, 0, 5, 0);
            add(sigObj, gc);
            sigObj.setSize(100,100);
            sigObj.clearTablet();
            //setTitle( "Signature" );


            // eingabe löschen
            clearButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.out.println(sigObj.getKeyReceipt());
                    sigObj.clearTablet();
                }
            });


            // Bild speichern
            saveJpgButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    try {
                        sigObj.setTabletState(0);
                        sigObj.setImageJustifyMode(5);
                        sigObj.setImagePenWidth(10);
                        sigObj.setImageXSize(1000);
                        sigObj.setImageYSize(350);
                        BufferedImage sigImage = sigObj.sigImage();
                        int w = sigImage.getWidth(null);
                        int h = sigImage.getHeight(null);
                        int[] pixels = new int[(w * h) * 2];

                        sigImage.setRGB(0, 0, 0, 0, pixels, 0, 0);
                        sigObj.setTabletState(1);

                        if(generateImg) {
                            String tmpTmpFolder = System.getProperty("java.io.tmpdir");
                            ImageIO.write(sigImage, "JPG", new File(tmpTmpFolder + File.separatorChar + "tmp_signature.jpg"));
                        }
                        String img64 = imageToDataUrl(sigImage);
                        System.out.println(img64);
                        callbackMethod("callbackApplet",img64);
                    }
                    catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });



            // setup connection
            sigObj.setTabletModel(model);
            sigObj.setTabletComPort(comPort);

            // start pad
            sigObj.setTabletState(0);
            sigObj.setTabletState(1);

            eventThread = new Thread(this);
            eventThread.start();

        }
        catch ( Exception e )
        {
            return;
        }
    }

    public void callbackMethod(String functionName, String argument) {
        JSObject win = JSObject.getWindow(this);
        win.call(functionName, new Object[] { argument });
    }

    public void run()
    {
        try
        {
            while ( true )
            {
                Thread.sleep(100);
            }
        }
        catch (InterruptedException e)
        {
        }
    }



    //Convenience method for GridBagLayout
    private void setConstraints(
            Component comp,
            GridBagLayout gbl,
            GridBagConstraints gc,
            int gridx,
            int gridy,
            int gridwidth,
            int gridheight,
            int weightx,
            int weighty,
            int anchor,
            int fill,
            int top,
            int left,
            int bottom,
            int right)
    {
        gc.gridx = gridx;
        gc.gridy = gridy;
        gc.gridwidth = gridwidth;
        gc.gridheight = gridheight;
        gc.weightx = weightx;
        gc.weighty = weighty;
        gc.anchor = anchor;
        gc.fill = fill;
        gc.insets = new Insets(top, left, bottom, right);
        gbl.setConstraints(comp, gc);
    }


    public static String imageToDataUrl(RenderedImage img) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();

        try {
            ImageIO.write(img, "jpg", bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String data = DatatypeConverter.printBase64Binary(bytes.toByteArray()),
                //proper data url format
                //dataUrl = "data:image/jpg;base64," + data;
                dataUrl=data;

        return dataUrl;
    }
}