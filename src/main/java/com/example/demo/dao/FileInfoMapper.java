package com.example.demo.dao;

import com.example.demo.dto.FileInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileInfoMapper {

    public Integer insertFile(FileInfo fileInfo);

    public List<FileInfo> queryAll();

}
