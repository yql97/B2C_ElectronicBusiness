package main.java.shiro.util;

public class RequestResult {
       private int result_code;
       private Object result_object;
       
	public RequestResult() {
		super();
	}
	public RequestResult(int result_code, Object result_object) {
		super();
		this.result_code = result_code;
		this.result_object = result_object;
	}
	public int getResult_code() {
		return result_code;
	}
	public void setResult_code(int result_code) {
		this.result_code = result_code;
	}
	public Object getResult_object() {
		return result_object;
	}
	public void setResult_object(Object result_object) {
		this.result_object = result_object;
	}
       
}
