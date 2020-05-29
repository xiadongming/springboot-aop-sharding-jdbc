package com.example.demo.commonutils;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadPic2ExcelUtil {

    public static void  DownloadPic2Excel(String pictPath, String fileName, HttpServletResponse response){
        FileOutputStream fileOut = null;
        BufferedImage bufferImg = null;
        //先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
        try {
            ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
          //  bufferImg = ImageIO.read(new File("F:/图片/照片/无名氏/小昭11.jpg"));
          //  ImageIO.write(bufferImg, "jpg", byteArrayOut);
            bufferImg = ImageIO.read(new File(pictPath));
            ImageIO.write(bufferImg, ".jpg", byteArrayOut);

            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet1 = wb.createSheet("picture");
            //画图的顶级管理器，一个sheet只能获取一个（一定要注意这点）
            HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
            //anchor主要用于设置图片的属性
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,(short) 1, 1, (short) 5, 8);
            anchor.setAnchorType(3);
            //插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
            fileOut = new FileOutputStream("D:\\logs\\down\\data.xlsx");//123.xlsx
            // 写入excel文件
            wb.write(fileOut);
            System.out.println("----Excle文件已生成------");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(fileOut != null){
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
