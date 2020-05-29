package com.example.demo.commonutils;

import com.example.demo.dto.JsonFileDto;
import com.example.demo.jobs.KafkaConsumerJobs;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static com.example.demo.common.RedisKeys.JSON_POSITIION;

public class JsonFileParsServiceUtils {
    static final Logger logger = LoggerFactory.getLogger(JsonFileParsServiceUtils.class);

    /**
     * 假如是手动，或者算法组发送请求过来，才执行这个方法
     * 1.后端需要知道，具体的taskId和serviesId，才能去解析
     * **/

    public static void JsonPars() throws IOException {
        Gson gson = new Gson();
        String taskId = "123456789";
        String serviesId = "123456789";
        String jsonId = "123456789.json";
        File file = new File("D:\\usr\\local\\result\\123456789\\123456789\\" + jsonId);
        if(file.exists()){
            JsonFileDto jsonFileDto = null;
                    logger.info("=====服务器存在该文件：taskId="+taskId+", serviesId="+serviesId+",  jsonId="+jsonId);
            InputStreamReader inputStreamReader=null;
                inputStreamReader  = new InputStreamReader(new FileInputStream(file),"utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String LineTxt = null;
                while((LineTxt=bufferedReader.readLine()) != null){
                    System.out.println(LineTxt);
                    jsonFileDto = gson.fromJson(LineTxt, JsonFileDto.class);
                    System.out.println("======:   "+jsonFileDto);
                }

            System.out.println("===  "+jsonFileDto.getKey7());
            System.out.println("===  "+jsonFileDto.getKey8());
            System.out.println("===  "+jsonFileDto.getKey9());
        }
    }
}
