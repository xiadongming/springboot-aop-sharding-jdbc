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
public class DicumUtils2 {

    public static  void parseDum() throws IOException {
        File file = new File("C:\\Users\\999\\Desktop\\dicom\\1046440141");
        DicomInputStream dicomInputStream = new DicomInputStream(file);
        Attributes attributes = dicomInputStream.readDataset(-1, Tag.PixelData);
        int[] tags = attributes.tags();

        byte[] bytes = attributes.getBytes(Tag.PixelData);


        System.out.println("Tag.PixelData   "+Tag.PixelData);
        System.out.println(attributes.size());
        System.out.println(attributes.toString());
        System.out.println(attributes.getString(Tag.PatientID));
    }

    public static void main(String[] args) throws IOException {
        DicumUtils2.parseDum();
    }


}
