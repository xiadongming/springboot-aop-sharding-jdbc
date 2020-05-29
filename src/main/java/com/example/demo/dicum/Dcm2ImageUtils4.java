package com.example.demo.dicum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/***
 *@auther xiadongming
 *@date 2020/5/21
 **/
public class Dcm2ImageUtils4 {
    public static void convertToJPEGImageFor16BitUnsigned(int nRows, int nColumns, float fW, float fC,
                                                          byte[] pixelData, String strDesPath) throws IOException {
        if (pixelData == null) {
            return;
        }

        short[] shortPixelData = toShortArray(pixelData);

        float fMin = (float) ((2.0f * fC - fW) / 2.0f + 0.5);
        float fMax = (float) ((2.0f * fC + fW) / 2.0f + 0.5);
        BufferedImage BI = new BufferedImage(nColumns, nRows, BufferedImage.TYPE_INT_RGB);

        for (int h = 0; h < nRows; h++) {

            for (int w = 0; w < nColumns; w++) {
                int index = w + h * nColumns;
                short pixel = shortPixelData[index];
                // int value = (int) (((pixel - fC) / fW + 0.5) * 255.0);
                int value = (int) ((pixel - fMin) * 255.0 / (fMax - fMin));
                int newVal = Math.min(Math.max(value, 0), 255);
                int pixelValue = 0xffffffff;
                pixelValue = (newVal << 16) & 0x00ff0000 | (pixelValue & 0xff00ffff);
                pixelValue = (newVal << 8) & 0x0000ff00 | (pixelValue & 0xffff00ff);
                pixelValue = (newVal) & 0x000000ff | (pixelValue & 0xffffff00);
                BI.setRGB(w, h, pixelValue);
            }
        }

        ImageIO.write(BI, "jpg", new File(strDesPath));
    }

    private static short[] toShortArray(byte[] src) {

        int count = src.length >> 1;
        short[] dest = new short[count];
        for (int i = 0; i < count; i++) {
            dest[i] = (short) ((src[i * 2] & 0xff) | ((src[2 * i + 1] & 0xff) << 8));
        }
        return dest;
    }
}
