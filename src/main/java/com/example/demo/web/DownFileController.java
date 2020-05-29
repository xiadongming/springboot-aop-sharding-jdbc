package com.example.demo.web;

import com.example.demo.commonutils.DownloadPic2ExcelUtil;
import com.example.demo.commonutils.DownloadUtil;
import com.example.demo.commonutils.ImageTools;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/***
 * 下载图片。并展示在excel上
 * **/
@RestController
@RequestMapping("/web")
public class DownFileController {
    Logger logger = LoggerFactory.getLogger(DownFileController.class);
    @RequestMapping("/down")
    public void downFile(HttpServletResponse resp, HttpServletRequest req){
       //下载到浏览器中的路径下
        String url = "D:\\logs\\upload\\timg.jpg";
        DownloadUtil.downloadFile(url,"123.jpg",resp,req);
        logger.info("下载成功");
    }
    //没有测试，
    @RequestMapping("/downVideo")
    public void downFileVideo(HttpServletResponse resp, HttpServletRequest req){
       //下载到浏览器中的路径下
        String url = "D:\\logs\\upload\\timg.jpg";
        DownloadUtil.downloadFile(url,"123.jpg",resp,req);
        logger.info("下载成功");
    }
    /**
     * 下载图片到excel中
     * **/
    @RequestMapping("/downExcel")
    public void downFile2Excel(HttpServletResponse resp, HttpServletRequest req){

        DownloadPic2ExcelUtil.DownloadPic2Excel("D:\\logs\\upload\\timg.jpg","",resp);

        logger.info("下载成功");
    } /**
     * 下载图片到excel中
     * **/
    @RequestMapping("/downExcel2")
    public void downFile2Excel2(HttpServletResponse resp, HttpServletRequest req) throws IOException {

        //文件名称
        String filename = "D:\\logs\\upload\\timg.jpg";
        //文件后缀(后缀检查略过)
      /*  String prefix= filename.substring(filename.lastIndexOf("."));
        File newFile = File.createTempFile(System.currentTimeMillis()+"",prefix);
        file.transferTo(newFile);*/
        File newFile = new File(filename);

        //转码BASE64可以存储数据库
        //OSS
        String imageToBase64 = ImageTools.ImageToBase64(newFile.getPath());
        //String filepath = request.getSession().getServletContext().getRealPath("/") + "upload" + filename;
        ImageTools.Base64ToImage(imageToBase64,newFile.getPath());

        BufferedImage bufferImg ;//图片一
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
        //读图片
        bufferImg = ImageIO.read(newFile);
        ImageIO.write(bufferImg, "png", byteArrayOut);
        // 创建一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        //创建一个sheet
        HSSFSheet sheet = wb.createSheet("sheet1");

        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();


        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        //设置水平对齐的样式为居中对齐;
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //设置垂直对齐的样式为居中对齐;
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        row.setHeight((short) (35.7*30));


            /**
             * 该构造函数有8个参数
             * 前四个参数是控制图片在单元格的位置，分别是图片距离单元格left，top，right，bottom的像素距离
             * 后四个参数，前2个表示图片左上角所在的cellNum和 rowNum，后2个参数对应的表示图片右下角所在的cellNum和 rowNum，
             * excel中的cellNum和rowNum的index都是从0开始的
             */
            HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0,
                    (short) 2, (2), (short) 8, (18));
            anchor.setAnchorType(ClientAnchor.MOVE_DONT_RESIZE);
            // 插入图片
            patriarch.createPicture(anchor, wb.addPicture(byteArrayOut
                    .toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG)).resize(0.5);

        resp.setContentType("application/vnd.ms-excel");
        //设置文件名称
        resp.setHeader("Content-disposition", "attachment;filename=export.xls");
        OutputStream outputStream = resp.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
        outputStream.close();
        //try catch这些关闭流略
        logger.info("下载成功");
    }
}


