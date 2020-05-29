package com.example.demo.dicum;

import org.dcm4che3.data.Attributes;
import org.dcm4che3.data.Tag;
import org.dcm4che3.io.DicomInputStream;

import java.io.File;
import java.io.IOException;

/***
 *@auther xiadongming
 *@date 2020/5/21
 **/
public class DicumUtils4 {
    private static void readMultiFrameDicom()  throws IOException {
        DicomInputStream dis = new DicomInputStream(new File("C:\\Users\\999\\Desktop\\dicom\\1046440141"));
        Attributes d = dis.readDataset(-1, -1);
        int nNumberOfFrames = d.getInt(Tag.NumberOfFrames, 0);

        int nRows = d.getInt(Tag.Rows, 0);
        int nColumns = d.getInt(Tag.Columns, 0);

        int nBitsAllocated = d.getInt(Tag.BitsAllocated, 0);
        byte[] pixelData = d.getBytes(Tag.PixelData);

        byte[] desPixelData = new byte[nRows*nColumns*2];
        byte[] bytes = intToBytes(Tag.PixelData, desPixelData.length);

        for(int i=0;i<nNumberOfFrames;i++) {
            System.arraycopy(bytes, i*desPixelData.length, desPixelData, 0, desPixelData.length);
            Dcm2ImageUtils4.convertToJPEGImageFor16BitUnsigned(nRows, nColumns, 1024, 512, desPixelData, "C:\\Users\\999\\Desktop\\pict\\"+i+".jpg");
        }
    }

    public static void main(String[] args) throws IOException {
        readMultiFrameDicom();
    }
    private static byte[] intToBytes(int a, int length) {
        byte[] bs = new byte[length];
        for (int i = bs.length - 1; i >= 0; i--) {
            bs[i] = (byte) (a % 0xFF);
            a = a / 0xFF;
        }
        return bs;
    }


}
