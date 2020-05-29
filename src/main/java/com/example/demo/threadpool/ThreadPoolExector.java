package com.example.demo.threadpool;

import com.example.demo.dto.FileInfo;
import com.example.demo.elasticsearch.FileResponity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ThreadPoolExector {


    @Autowired
    private FileResponity fileResponity;

    /**
 * 由线程池执行此方法
 * */
    @Async("taskExecutor")
    public void task(){
        System.out.println("线程池："+Thread.currentThread().getName());
        FileInfo fileInfo = new FileInfo();
        fileInfo.setPositon("/user/local/");
        fileInfo.setFileId("1234L");
        fileInfo.setId(1234L);
        System.out.println("向es中存储");
        fileResponity.save(fileInfo);

        System.out.println("查询es");
        Optional<FileInfo> byId = fileResponity.findById(1234);
        System.out.println(byId.toString());
    }

}
