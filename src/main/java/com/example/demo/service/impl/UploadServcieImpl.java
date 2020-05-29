package com.example.demo.service.impl;

import com.example.demo.dto.FileInfo;
import com.example.demo.dao.FileInfoMapper;
import com.example.demo.service.UploadServcie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadServcieImpl implements UploadServcie {
    Logger logger = LoggerFactory.getLogger(UploadServcieImpl.class);
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Override
    public Integer insertFile(FileInfo fileInfo) {
        logger.info("上传的对象信息："+fileInfo.toString());
        Integer insertFile = null;
        try{
            insertFile = fileInfoMapper.insertFile(fileInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        return insertFile;
    }
}
