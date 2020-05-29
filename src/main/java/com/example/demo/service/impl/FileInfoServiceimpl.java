package com.example.demo.service.impl;

import com.example.demo.dao.FileInfoMapper;
import com.example.demo.dto.FileInfo;
import com.example.demo.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 *  @auther xiadongming
 *  @date 2020/5/29
 **/
@Service
public class FileInfoServiceimpl implements FileInfoService {
    @Autowired
    private FileInfoMapper fileInfoMapper;
    @Override
    public List<FileInfo> queryll() {
        return fileInfoMapper.queryAll();
    }
}
