package main.java.shiro.util;



import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class httpClient {

    /*public static Object httpClientGet(String  url){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet =new HttpGet(url);
        CloseableHttpResponse  response = null;
            response =httpClient.execute(httpGet);
            HttpEntity  responseEntity =response.getEntity();
            System.out.println("响应状态为"+response.getStatusLine());
            if(responseEntity!=null){
                System.out.print("响应长度为"+responseEntity.getContentLength());
                System.out.print("响应内容"+EntityUtils.toString(responseEntity));
                  return EntityUtils.toString(responseEntity);
            }
        return "";
    }
    public static Object httpClientPost(String  url){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost =new HttpPost(url);
        CloseableHttpResponse  response = null;
        response =httpClient.execute(httpPost);
        HttpEntity  responseEntity =response.getEntity();
        System.out.println("响应状态为"+response.getStatusLine());
        if(responseEntity!=null){
            System.out.print("响应长度为"+responseEntity.getContentLength());
            System.out.print("响应内容"+EntityUtils.toString(responseEntity));
            return EntityUtils.toString(responseEntity);
        }
        return "";
    }*/
}
