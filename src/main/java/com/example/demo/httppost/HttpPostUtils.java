package com.example.demo.httppost;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/***
 *@auther xiadongming
 *@date 2020/5/20
 **/
public class HttpPostUtils {

    public void httpRequest() throws IOException {
        CloseableHttpClient client = HttpClients.createDefault();
       // HttpPost httpPost = new HttpPost("192.168.199.229");
        HttpGet httpGet = new HttpGet("http://192.168.199.229:80");
        RequestConfig config = RequestConfig.custom().setSocketTimeout(30000).setConnectTimeout(20000).build();
        httpGet.setConfig(config);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();
        multipartEntityBuilder.setCharset(Charset.forName("utf-8"));
        ContentType contentType = ContentType.create("text/plain", Consts.UTF_8);

        multipartEntityBuilder.addTextBody("dateStr", "dateStr111");
        multipartEntityBuilder.addTextBody("patientInfo", "patientInfo222", contentType);
        multipartEntityBuilder.addTextBody("projectId", "projectId333");
        multipartEntityBuilder.addTextBody("localPosition", "localPosition444", contentType);

        HttpEntity httpEntity = multipartEntityBuilder.build();
        //httpPost.setEntity(httpEntity);

        CloseableHttpResponse httpResponse = client.execute(httpGet);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        System.out.println("statusCode: "+statusCode);
    }

    public static void main(String[] args) {
        HttpPostUtils httpPostUtils = new HttpPostUtils();
        try{
            httpPostUtils.httpRequest();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
