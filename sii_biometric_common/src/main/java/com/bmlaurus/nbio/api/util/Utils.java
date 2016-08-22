package com.bmlaurus.nbio.api.util;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by acanaveral on 18/8/16.
 */
public class Utils {

    private static IndexColorModel myCM = null;

    static {
        byte[] rgb = new byte[256];

        for(int j = 0; j < rgb.length; ++j) {
            rgb[j] = (byte)j;
        }

        myCM = new IndexColorModel(8, 256, rgb, rgb, rgb);
    }

    public static byte[] rawToJPG(byte[] tmpRAWImg, int inWidth, int inHeight) {
        MemoryImageSource source = new MemoryImageSource(inWidth, inHeight, myCM, tmpRAWImg, 0, inWidth);
        Image newImage = Toolkit.getDefaultToolkit().createImage(source);
        BufferedImage bimage = new BufferedImage(inWidth, inHeight, 1);
        Graphics2D tmpGraph = bimage.createGraphics();
        tmpGraph.setComposite(AlphaComposite.getInstance(3, 1.0F));
        tmpGraph.setBackground(Color.WHITE);
        tmpGraph.fillRect(0, 0, bimage.getWidth(), bimage.getHeight());
        tmpGraph.drawImage(newImage, 0, 0, null);
        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();

        try {
            ImageIO.write(bimage, "jpeg", outBuffer);
        } catch (IOException var9) {
            var9.printStackTrace();
        }

        return outBuffer.toByteArray();
    }

    public static byte[] bufferedImageToPNG(int imageWidth, int imageHeight, byte[] data){
        byte[] img = null;
        BufferedImage bufImage = new BufferedImage(imageWidth, imageHeight,BufferedImage.TYPE_BYTE_GRAY);
        bufImage.getRaster().setDataElements(0, 0, imageWidth, imageHeight,data);

        ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufImage, "JPG", outBuffer);
            img = outBuffer.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return img;
    }

    public static String bufferedImageToPNGBase64(int imageWidth, int imageHeight, byte[] data){
        return getBase64Image(bufferedImageToPNG(imageWidth,imageHeight,data));
    }

    public static String getBase64Image(byte[] image){
        String base64 = null;
        if(image!=null)
            base64 = Base64.encodeBase64String(image);
        return base64;
    }

    public static String rawToBase64(byte[] tmpRAWImg, int inWidth, int inHeight){
        return getBase64Image(rawToJPG(tmpRAWImg,inWidth,inHeight));
    }
}
