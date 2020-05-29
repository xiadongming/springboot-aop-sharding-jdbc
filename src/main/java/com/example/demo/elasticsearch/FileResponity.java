package com.example.demo.elasticsearch;

import com.example.demo.dto.FileInfo;
import com.example.demo.dto.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileResponity extends ElasticsearchRepository<FileInfo,Integer> {
}
