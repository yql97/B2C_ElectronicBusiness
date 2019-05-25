/**
 * 
 */
package ECS_Common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @author yueqiulin
 *
 */
public class ReqResultUtil {
  public static String getSuccessResponse(){
	  RequestResult requestResult =new RequestResult(); 
	  requestResult.setResult_code(200);
	  requestResult.setResult_object("成功");
	  return  JSONObject.toJSONString(requestResult);
  }
  public static  String getSuccessResponse(Object object){
	  RequestResult requestResult =new RequestResult(); 
	  requestResult.setResult_object(object);
	  requestResult.setResult_code(200);
	  return  JSONObject.toJSONString(requestResult);
  }
  public static String getFailedResponse(){
	  RequestResult requestResult =new RequestResult(); 
	  requestResult.setResult_object("失败");
	  requestResult.setResult_code(400);
	  return  JSONObject.toJSONString(requestResult);
  }
  public static  String getFailedResponse(Object object){
	  RequestResult requestResult =new RequestResult(); 
	  requestResult.setResult_object(object);
	  requestResult.setResult_code(400);
	  return  JSONObject.toJSONString(requestResult);
  }
}
