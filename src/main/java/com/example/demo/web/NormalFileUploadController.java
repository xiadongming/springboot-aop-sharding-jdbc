package com.example.demo.web;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/***
 add by xiadongming on 2020/5/16
 **/
@RestController
@RequestMapping("/web")
public class NormalFileUploadController {
    /**
     *两种文件上传技术，和视频上传技术(断点续传不同)
     * 推荐第一种
     **/
    @RequestMapping("/fileUpload2")
    public void normalFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String filePath = "D:\\0_000ffmpeg\\normal";
        File file1 = new File(filePath,originalFilename);
        file.transferTo(file1);

        //上传成功

    }
    @RequestMapping("/fileUpload")
    public void normalFileUpload2(@RequestParam("file") MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream in = file.getInputStream();
        String filePath = "D:\\0_000ffmpeg\\normal\\" + originalFilename;

        File outFile = new File(filePath);
        OutputStream os = new FileOutputStream(outFile);
        IOUtils.copy(in, os);
        //上传成功

    }

}
