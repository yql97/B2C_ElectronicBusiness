package ECS_Common.util;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class httpClient {

    public static String httpClientGet(String  url,Map<String,Object> param){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        RequestResult rr=new RequestResult();
        CloseableHttpResponse  response = null;
            try {
            	 URIBuilder builder;
					builder = new URIBuilder(url);
                 if (param != null) {
                     for (String key : param.keySet()) {
                         builder.addParameter(key, param.get(key).toString());
                     }
                 }
                 URI uri = builder.build();
                 HttpGet httpGet =new HttpGet(uri);
                 //设置期望服务端返回的编码
                 httpGet.setHeader("Authorization",param.get("sessionID").toString());
				response =httpClient.execute(httpGet);
				HttpEntity  responseEntity =response.getEntity();
	            System.out.println("响应状态为"+response.getStatusLine());
	            if(responseEntity!=null){
	                System.out.print("响应长度为"+responseEntity.getContentLength());
					//	System.out.print("响应内容"+EntityUtils.toString(responseEntity));	
						//return ReqResultUtil.getSuccessResponse();
							return	EntityUtils.toString(responseEntity,"UTF-8");
	               /* rr.setResult_object(EntityUtils.toString(responseEntity));
	                return rr;*/
	            }
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             return "false";
    }
    public static String httpClientPost(String  url,Map<String,Object> param){
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse  response = null;
        RequestResult rr=new RequestResult();
        try {
         HttpPost httpPost =new HttpPost(url);
         httpPost.setHeader("Authorization",param.get("sessionID").toString());
        if (param != null) {
            List<NameValuePair> paramList = new ArrayList<NameValuePair>();
            for (String key : param.keySet()) {
                paramList.add(new BasicNameValuePair(key, param.get(key).toString()));
            }
            // 模拟表单
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList,HTTP.UTF_8);
            httpPost.setEntity(entity);
        }
			response =httpClient.execute(httpPost);
			 HttpEntity  responseEntity =response.getEntity();
		        System.out.println("响应状态为"+response.getStatusLine());
		        if(responseEntity!=null){
		            System.out.print("响应长度为"+responseEntity.getContentLength());
		            return	EntityUtils.toString(responseEntity,"UTF-8");
		           // System.out.print("响应内容"+EntityUtils.toString(responseEntity));
		           /* rr.setResult_object(EntityUtils.toString(responseEntity));
		            return rr;*/
		        }
	
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        return "false";
    }
   /* public static void main(String[] args) {
    	Map<String,Object> param =new HashMap<String,Object>();
    	param.put("user_id",444444);
    	RequestResult str=(RequestResult)httpClient.httpClientGet("http://localhost:9090/ECS_Common//account//getAccountInfo.action",
				param);
		System.out.println(str.getResult_object().toString());
	}*/
}
