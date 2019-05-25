package ECS_Goods.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import ECS_Common.util.API;
import ECS_Common.util.RequestResult;
import ECS_Common.util.httpClient;

@Service
public class autherInfo {
	
	 public RequestResult getBusiness(Integer id) {
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("sessionID",id);
		   String result=httpClient.httpClientGet(API.ECS_User+"/getBusinessInfo.action",map);
		   RequestResult res=JSONObject.toJavaObject(JSONObject.parseObject(result),RequestResult.class);
		   return res;
	 }
	 public String  getAuther(HttpServletRequest request) throws IOException {
		 Cookie[] cookie=request.getCookies();
		 String userid ="";
		 for(Cookie c:cookie) {
			 if(c.getName().equals("sessionID"))  userid=c.getValue();
		 }
		  RequestResult o =getBusiness(Integer.parseInt(userid));
		  if(o.getResult_object().equals("失败")&&o.getResult_code()==400) {
			  return "index";
		  }
		  return userid;
	 }
}
