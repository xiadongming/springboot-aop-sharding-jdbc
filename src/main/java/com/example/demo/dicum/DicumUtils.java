package com.example.demo.dicum;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import ij.plugin.DICOM;
import org.apache.commons.io.FileUtils;
import org.dcm4che3.data.Tag;
import org.dcm4che3.data.VR;
import org.dcm4che3.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/***
 *@auther xiadongming
 *@date 2020/5/21
 **/
public class DicumUtils {
    public static void main(String args[]) {
         //在本地目录生成test1.dcm.jpg图片文件
        create3("C:\\Users\\999\\Desktop\\dicom\\1046490189");   //在电脑dicom文件夹下生成test1.dcm.jpg图片文件

    }

    private static void create3(String filePath) {
        DICOM dicom = new DICOM();
/*        dicom.run(filePath);
        System.out.println("dicom："+dicom);
        int frame = dicom.getFrame();
        int nFrames = dicom.getNFrames();*/
        dicom.open(filePath);
        int[] dimensions = dicom.getDimensions();
        for (int i=0;i<dimensions.length;i++){
            System.out.println(dimensions[i]);
        }

    }

    /**
     * 输入一个dicom文件的绝对路径和名字
     * 获取一个jpg文件
     */
    private static void create2(String filePath) {
        try {
            DICOM dicom = new DICOM();
            dicom.run(filePath);
            System.out.println("dicom："+dicom);

            BufferedImage bi = (BufferedImage) dicom.getImage();


            int width = bi.getWidth();
            int height = dicom.getHeight();
            System.out.println("width: " + width + "\n" + "height: " + height);
            String imagePath = filePath + ".jpg";
            ImageIO.write(bi, "jpg", new File(imagePath));

        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
            e.printStackTrace();
        }

    }


    /**
     * 根据dicom文件生成jpg图片
     * <p/>
     * 这里输入的是image文件夹的dicom文件名字，
     * 运行即可得到一个jpg图片，显示的是dicom里面的图形
     */
    private static void create(String fileName) {
        try {
            String projectPath = System.getProperty("user.dir");
            //Check class DICOM
            DICOM dicom = new DICOM();
            String imagePath = projectPath + "\\image\\" + fileName;
            dicom.run(imagePath);
            BufferedImage bi = (BufferedImage) dicom.getImage();
            int width = bi.getWidth();
            int height = dicom.getHeight();
            System.out.println("width: " + width + "\n" + "height: " + height);
            imagePath = projectPath + "\\image\\" + fileName + ".jpg";
            ImageIO.write(bi, "jpg", new File(imagePath));
            System.out.println("Hehe,Game over!!!");

        } catch (Exception e) {
            System.out.println("错误" + e.getMessage());
        }

    }

}
