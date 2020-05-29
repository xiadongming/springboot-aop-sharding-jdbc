package com.example.demo.dto;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.io.Serializable;
@Table(name = "file_info")
@Document(indexName = "product_index",type = "product",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class FileInfo implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Transient,标识忽略改属性到数据库的映射
    @Column(name="file_id")
    private String fileId;
    @Column(name="position")
    private String position;

    public String getFileId() {
        return fileId;
    }

    public String getPosition() {
        return position;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setPositon(String position) {
        this.position = position;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", fileId='" + fileId + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
